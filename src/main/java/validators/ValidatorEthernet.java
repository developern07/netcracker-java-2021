package validators;

import contracts.ContractDefault;
import contracts.ContractEthernet;
import functions.Message;
import helpers.CheckStatus;

/**
 * Model ethernet validator
 * @see ZIValidator
 */
public class ValidatorEthernet implements ZIValidator {
    @Override
    public <T extends ContractDefault> Message validate(T contract) {
        if (((ContractEthernet)contract).getSpeedConnection() <= 0){
            return new Message("Speed connection", CheckStatus.ERROR);
        }
        return new Message("Ethernet parameters of contract", CheckStatus.OK);
    }

    @Override
    public Class<?> getAppliableFor() {
        return ContractEthernet.class;
    }
}