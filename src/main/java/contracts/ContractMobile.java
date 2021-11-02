package contracts;

import entities.Person;

import java.time.LocalDate;

/**
 * Mobile contract model
 * @see ContractDefault
 */
public class ContractMobile extends ContractDefault {

    /**
     * Amount of minutes
     */
    protected int aMinutes;

    public int getaMinutes() {
        return aMinutes;
    }

    public void setaMinutes(int aMinutes) {
        this.aMinutes = aMinutes;
    }

    /**
     * Amount of sms
     */
    protected int aSMS;

    public int getaSMS() {
        return aSMS;
    }

    public void setaSMS(int aSMS) {
        this.aSMS = aSMS;
    }

    /**
     * Amount of gb traffic
     */
    protected int gbTraffic;

    public int getGbTraffic() {
        return gbTraffic;
    }

    public void setGbTraffic(int gbTraffic) {
        this.gbTraffic = gbTraffic;
    }

    public ContractMobile(int id, LocalDate dOfStartContract, LocalDate dOfEndContract, int nOfContract, Person human, int aMinutes, int aSMS, int gbTraffic) {
        super(id, dOfStartContract, dOfEndContract, nOfContract, human);
        setaMinutes(aMinutes);
        setaSMS(aSMS);
        setGbTraffic(gbTraffic);
    }
}
