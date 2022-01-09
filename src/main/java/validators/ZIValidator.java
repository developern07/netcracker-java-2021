package validators;

import contracts.ContractDefault;
import functions.Message;

/**
 * Interface validator
 */
public interface ZIValidator {
    /**
     * Method of getting result of check
     * @param contract
     * @param <T>
     * @return Message
     */
    public <T extends ContractDefault> Message validate(T contract);

    /**
     * Method of getting class
     * @return *.class
     * @throws ClassNotFoundException
     */
    public Class<?> getAppliableFor() throws ClassNotFoundException;
}