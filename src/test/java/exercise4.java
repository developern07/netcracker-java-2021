import contracts.ContractDefault;
import contracts.ContractEthernet;
import contracts.ContractMobile;
import contracts.ContractTV;
import entities.Person;
import functions.CSVLoader;
import helpers.Gender;
import org.junit.Test;
import repository.Repository;
import validators.*;

import java.time.LocalDate;

public class exercise4 {
    @Test
    public void validate_Default(){
        DefaultValidator defaultValidator = new DefaultValidator();
        Person person = new Person(1, "Nikita", LocalDate.of(2000, 6, 28), Gender.Male, "2014 456287");
        ContractDefault contract = new ContractDefault(1, LocalDate.of(2019, 1, 1),
                LocalDate.of(2021, 1, 1), 1, person);
        System.out.println(defaultValidator.validate(contract).toString());
    }

    @Test
    public void validate_Person(){
        ValidatorPerson validatorPerson = new ValidatorPerson();
        Person person = new Person(1, "Nikita", LocalDate.of(2000, 6, 28), Gender.Male, "2014 456287");
        ContractDefault contract = new ContractDefault(1, LocalDate.of(2019, 1, 1),
                LocalDate.of(2021, 1, 1), 1, person);
        System.out.println(validatorPerson.validate(contract).toString());
    }

    @Test
    public void validate_Ethernet(){
        ValidatorEthernet validatorEthernet = new ValidatorEthernet();
        Person person = new Person(1, "Nikita", LocalDate.of(2000, 6, 28), Gender.Male, "2014 456287");
        ContractDefault contract = new ContractEthernet(1, LocalDate.of(2019, 1, 1),
                LocalDate.of(2021, 1, 1), 1, person, 500);
        System.out.println(validatorEthernet.validate(contract).toString());
    }

    @Test
    public void validate_Mobile(){
        ValidatorMobile validatorMobile = new ValidatorMobile();
        Person person = new Person(1, "Nikita", LocalDate.of(2000, 6, 28), Gender.Male, "2014 456287");
        ContractDefault contract = new ContractMobile(1, LocalDate.of(2019, 1, 1),
                LocalDate.of(2021, 1, 1), 1, person, 50, 200, 10);
        System.out.println(validatorMobile.validate(contract).toString());
    }

    @Test
    public void validate_TV(){
        ValidatorTV validatorTV = new ValidatorTV();
        String [] string = {"SPORT", "KIDS", "COMEDY"};
        Person person = new Person(1, "Nikita", LocalDate.of(2000, 6, 28), Gender.Male, "2014 456287");
        ContractDefault contract = new ContractTV(1, LocalDate.of(2019, 1, 1),
                LocalDate.of(2021, 1, 1), 1, person, 3, string);
        System.out.println(validatorTV.validate(contract).toString());
    }

    @Test
    public void checkCSV() throws Exception {
        Repository contracts = new Repository();
        CSVLoader reader = new CSVLoader();
        reader.readAndParseCSV("src/main/resources/data.csv", contracts);
    }
}
