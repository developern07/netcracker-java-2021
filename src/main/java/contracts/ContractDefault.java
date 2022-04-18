package contracts;

import entities.Person;
import helpers.Gender;
import xml.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Contract model
 */
@XmlRootElement
@XmlSeeAlso({Gender.class, Person.class, LocalDate.class})
public class ContractDefault implements Serializable {

    /**
     * Contract ID
     */
    protected int id;

    public ContractDefault() {

    }

    @XmlElement
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

    @XmlElement
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
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

    @XmlElement
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
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

    @XmlElement
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

    @XmlAnyElement
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
