package validators;

import contracts.ContractDefault;
import contracts.ContractTV;
import functions.Message;
import helpers.CheckStatus;

/**
 * Model TV validator
 * @see validators.IValidator
 */
public class ValidatorTV implements IValidator{
    @Override
    public <T extends ContractDefault> Message validate(T contract) {
        if (((ContractTV)contract).getPackageChannel().length <= 1){
            return new Message("Package channel", CheckStatus.ERROR);
        }
        return new Message("TV parameters of contract", CheckStatus.OK);
    }

    @Override
    public Class<?> getAppliableFor() {
        return ContractTV.class;
    }
}