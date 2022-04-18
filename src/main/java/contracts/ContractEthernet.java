package contracts;

import entities.Person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * Ethernet contract model
 * @see ContractDefault
 */
@XmlRootElement
public class ContractEthernet extends ContractDefault {

    /**
     * Speed connection
     */
    protected int speedConnection;

    @XmlElement
    public int getSpeedConnection() {
        return speedConnection;
    }

    public void setSpeedConnection(int speedConnection) {
        this.speedConnection = speedConnection;
    }

    public ContractEthernet(int id, LocalDate dOfStartContract, LocalDate dOfEndContract, int nOfContract, Person human, int speedConnection) {
        super(id, dOfStartContract, dOfEndContract, nOfContract, human);
        setSpeedConnection(speedConnection);
    }
}
