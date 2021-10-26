package contracts;

import entities.Person;

import java.time.LocalDate;

public class ContractEthernet extends ContractDefault {

    protected int speedConnection;

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
