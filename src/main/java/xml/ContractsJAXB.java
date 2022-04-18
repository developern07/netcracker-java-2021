package xml;

import contracts.ContractDefault;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ContractsJAXB {

    List<ContractDefault> contractList = new ArrayList<>();

    @XmlElement
    public List<ContractDefault> getContractList() {
        return contractList;
    }

    public ContractsJAXB() {
    }
}