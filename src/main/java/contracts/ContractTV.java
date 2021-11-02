package contracts;

import entities.Person;

import java.time.LocalDate;

/**
 * TV contract model
 * @see ContractDefault
 */
public class ContractTV extends ContractDefault {
    /**
     * Amount of channels
     */
    protected int aChannel;

    public int getaChannel() {
        return aChannel;
    }

    public void setaChannel(int aChannel) {
        this.aChannel = aChannel;
    }

    /**
     * Names of channels
     */
    protected String[] packageChannel;

    public String[] getPackageChannel() {
        return packageChannel;
    }

    public void setPackageChannel(String[] packageChannel) {
        this.packageChannel = packageChannel;
    }

    public ContractTV(int id, LocalDate dOfStartContract, LocalDate dOfEndContract, int nOfContract, Person human, int aChannel, String[] packageChannel) {
        super(id, dOfStartContract, dOfEndContract, nOfContract, human);
        setaChannel(aChannel);
        setPackageChannel(packageChannel);
    }
}
