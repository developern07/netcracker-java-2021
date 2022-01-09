package validators;

import contracts.ContractDefault;
import contracts.ContractMobile;
import functions.Message;
import helpers.CheckStatus;

/**
 * Model mobile validator
 * @see ZIValidator
 */
public class ValidatorMobile implements ZIValidator {

    @Override
    public <T extends ContractDefault> Message validate(T contract) {
        if (((ContractMobile)contract).getaSMS() < 0){
            return new Message("Amount of sms", CheckStatus.ERROR);
        }
        if (((ContractMobile)contract).getaMinutes() < 0){
            return new Message("Amount of minutes", CheckStatus.ERROR);
        }
        if (((ContractMobile)contract).getGbTraffic() < 0){
            return new Message("Amount of gb traffic", CheckStatus.ERROR);
        }
        return new Message("Mobile parameters of contract", CheckStatus.OK);
    }

    @Override
    public Class<?> getAppliableFor() {
        return ContractMobile.class;
    }
}