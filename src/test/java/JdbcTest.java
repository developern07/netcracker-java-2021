import contracts.ContractDefault;
import contracts.ContractEthernet;
import contracts.ContractMobile;
import contracts.ContractTV;
import entities.Person;
import helpers.Gender;
import jdbc.PostgresDB;
import org.junit.Test;
import repository.Repository;

import java.time.LocalDate;


public class JdbcTest {
    /*
    1. to create a database, run the resources/docker-compose.yml file
    2. to create tables, run the resources/create.sql script
    */

    @Test
    public void saveRepositoryJDBC() {
        Repository repository = new Repository();

        Person person1 = new Person(1, "Petrov Petr Petrovich", LocalDate.of(2000, 1, 1), Gender.Male,"2014 123456");

        Person person2 = new Person(2, "Ivanov Ivan Ivanovich", LocalDate.of(2001, 2, 2), Gender.Male,"2015 123456");

        ContractDefault contract1 = new ContractEthernet(1, LocalDate.of(2020, 1, 1),
                LocalDate.of(2022, 1, 1), 1, person1, 500);

        String [] channels = {"SPORT", "KIDS", "COMEDY"};
        ContractDefault contract2 = new ContractTV(2, LocalDate.of(2019, 12, 1),
                LocalDate.of(2023, 1, 1), 2, person2, 3, channels);

        ContractDefault contract3 = new ContractMobile(3, LocalDate.of(2018, 12, 12),
                LocalDate.of(2025, 1, 1), 3, person1, 100, 100, 10);

        repository.add(contract1);
        repository.add(contract2);
        repository.add(contract3);

        PostgresDB postgres = new PostgresDB();
        postgres.saveRepositoryJDBC(repository);

    }

    @Test
    public void restoreRepositoryJDBC() {
        PostgresDB postgres = new PostgresDB();
        Repository repository = postgres.restoreRepositoryJDBC();
        System.out.println(repository.toString());
    }
}
