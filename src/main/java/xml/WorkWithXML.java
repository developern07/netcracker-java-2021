package xml;

import contracts.ContractDefault;
import repository.Repository;
import entities.Person;
import helpers.Gender;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class WorkWithXML {

    /**
     * Java to XML
     * @param repository repository with contracts
     */
    public void JAVAtoXML(Repository repository) {
        try {
            JAXBContext context = JAXBContext.newInstance(ContractsJAXB.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ContractsJAXB contractsList = new ContractsJAXB();
            ContractDefault[] contractList = repository.getAll();
            for (ContractDefault element : contractList) {
                contractsList.getContractList().add(element);
            }
            File output = new File("src/main/resources/testXML.xml");
            marshaller.marshal(contractsList, output);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * XML to Java
     * @return - repository with contracts
     */
    public Repository XMLtoJAVA(String file) {
        try {
            File xmlFile = new File(file);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("contractList");

            Repository repository = new Repository();
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) nNode;
                    String id = elem.getElementsByTagName("id").item(1).getTextContent();
                    String nOfContract = elem.getElementsByTagName("nOfContract").item(0).getTextContent();
                    String dOfStartContract = elem.getElementsByTagName("dOfStartContract").item(0).getTextContent();
                    String dOfEndContract = elem.getElementsByTagName("dOfEndContract").item(0).getTextContent();
                    NodeList list = doc.getElementsByTagName("person");
                    Node node = list.item(i);
                    Element elem1 = (Element) node;
                    String dateOfBirthday = elem1.getElementsByTagName("dateOfBirthday").item(0).getTextContent();
                    String name = elem1.getElementsByTagName("name").item(0).getTextContent();
                    String idPeople = elem1.getElementsByTagName("id").item(0).getTextContent();
                    String snPassport = elem1.getElementsByTagName("snPassport").item(0).getTextContent();
                    String gender = elem1.getElementsByTagName("gender").item(0).getTextContent();

                    ContractDefault contract = new ContractDefault(Integer.parseInt(id),LocalDate.parse(dOfStartContract),LocalDate.parse(dOfEndContract),Integer.parseInt(nOfContract),
                            new Person(Integer.parseInt(idPeople),name, LocalDate.parse(dateOfBirthday),Gender.valueOf(gender),snPassport));
                    repository.add(contract);
                }
            }
            return repository;
        } catch (SAXException | IOException | IllegalArgumentException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
