package contracts;

import entities.Person;

import java.time.LocalDate;

public class ContractDefault{

    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected LocalDate dOfStartContract;

    public LocalDate getdOfStartContract() {
        return dOfStartContract;
    }

    public void setdOfStartContract(LocalDate dOfStartContract) {
        this.dOfStartContract = dOfStartContract;
    }

    protected LocalDate dOfEndContract;

    public LocalDate getdOfEndContract() {
        return dOfEndContract;
    }

    public void setdOfEndContract(LocalDate dOfEndContract) {
        this.dOfEndContract = dOfEndContract;
    }

    protected int nOfContract;

    public int getnOfContract() {
        return nOfContract;
    }

    public void setnOfContract(int nOfContract) {
        this.nOfContract = nOfContract;
    }

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
