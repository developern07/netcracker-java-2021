package validators;

import contracts.ContractDefault;
import functions.Message;
import helpers.CheckStatus;

/**
 * Model default validator
 * @see ZIValidator
 */
public class DefaultValidator implements ZIValidator {

    @Override
    public <T extends ContractDefault> Message validate(T contract) {
        if (contract.getId()<=0) {
            return new Message("ID contract", CheckStatus.ERROR);
        }
        if (contract.getdOfStartContract().getYear() > contract.getdOfEndContract().getYear() || contract.getdOfStartContract().getYear() == contract.getdOfEndContract().getYear() && contract.getdOfStartContract().getDayOfYear() > contract.getdOfEndContract().getDayOfYear()){
            return new Message("Date of contract", CheckStatus.ERROR);
        }
        return new Message("Default parameters of contract", CheckStatus.OK);
    }

    @Override
    public Class<?> getAppliableFor() {
        return ContractDefault.class;
    }
}