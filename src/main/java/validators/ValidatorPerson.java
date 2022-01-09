package validators;

import contracts.ContractDefault;
import functions.Message;
import helpers.CheckStatus;

/**
 * Model human validator
 * @see ZIValidator
 */
public class ValidatorPerson implements ZIValidator {
    @Override
    public <T extends ContractDefault> Message validate(T contract) {
        if (contract.getHuman().getId()<=0){
            return new Message("ID of person", CheckStatus.ERROR);
        }
        if (contract.getHuman().getName().length()<=0){
            return new Message("Name of person", CheckStatus.ERROR);
        }
        if (contract.getHuman().getAge()<18){
            return new Message("Age of person", CheckStatus.ERROR);
        }
        if (contract.getHuman().getSnPassport().length()<11){
            return new Message("Passport of person", CheckStatus.ERROR);
        }
        return new Message("Person", CheckStatus.OK);
    }

    @Override
    public Class<?> getAppliableFor() {
        return ContractDefault.class;
    }
}
