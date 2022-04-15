package contracts;

import entities.Person;

import java.time.LocalDate;

/**
 * Contract model
 */
public class ContractDefault{

    /**
     * Contract ID
     */
    protected int id;

    public ContractDefault() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Date of start contract
     */
    protected LocalDate dOfStartContract;

    public LocalDate getdOfStartContract() {
        return dOfStartContract;
    }

    public void setdOfStartContract(LocalDate dOfStartContract) {
        this.dOfStartContract = dOfStartContract;
    }

    /**
     * Date of end contract
     */
    protected LocalDate dOfEndContract;

    public LocalDate getdOfEndContract() {
        return dOfEndContract;
    }

    public void setdOfEndContract(LocalDate dOfEndContract) {
        this.dOfEndContract = dOfEndContract;
    }

    /**
     * Number of contract
     */
    protected int nOfContract;

    public int getnOfContract() {
        return nOfContract;
    }

    public void setnOfContract(int nOfContract) {
        this.nOfContract = nOfContract;
    }

    /**
     * Contract owner
     */
    protected Person human;

    public Person getHuman() {
        return human;
    }

    public void setHuman(Person human) {
        this.human = human;
    }

    public ContractDefault(int id, LocalDate dOfStartContract, LocalDate dOfEndContract, int nOfContract, Person human) {
        setId(id);
        setdOfStartContract(dOfStartContract);
        setdOfEndContract(dOfEndContract);
        setnOfContract(nOfContract);
        setHuman(human);
    }
}
