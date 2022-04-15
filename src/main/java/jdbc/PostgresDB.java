package jdbc;

import contracts.*;
import entities.Person;
import helpers.Gender;
import repository.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PostgresDB {
    private static String url;
    private static String user;
    private static String password;

    public PostgresDB() {
        try (InputStream dbp = PostgresDB.class.getClassLoader().getResourceAsStream("database.properties")) {
            Properties props = new Properties();
            props.load(dbp);
            url = props.getProperty("Database.DataURL");
            user = props.getProperty("Database.Prop.user");
            password = props.getProperty("Database.Prop.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveRepositoryJDBC(Repository repository) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement customerInsert = connection.prepareStatement("INSERT INTO customers(id, fullname, date_of_birthday, gender, sn_passport) VALUES (?,?,?,?,?);");
            PreparedStatement contractInsert = connection.prepareStatement("INSERT INTO contracts(id, d_of_start_contract, d_of_end_contract, n_of_contract, customer_id, contract_type, detailed_info) VALUES (?, ?, ?, ?, ?, ?, ?);");
            for (int i = 1; i <= repository.getAll().length ; i++) {
                ContractDefault contract = repository.get(i);
                contractInsert.setInt(1,contract.getId());
                contractInsert.setDate(2, Date.valueOf(contract.getdOfStartContract()));
                contractInsert.setDate(3, Date.valueOf(contract.getdOfEndContract()));
                contractInsert.setInt(4,contract.getnOfContract());

                Person person = contract.getHuman();
                customerInsert.setInt(1,person.getId());
                customerInsert.setString(2,person.getName());
                customerInsert.setDate(3,Date.valueOf(person.getDateOfBirthday()));
                customerInsert.setString(4, String.valueOf(person.getGender()));
                customerInsert.setString(5,person.getSnPassport());

                contractInsert.setInt(5, person.getId());
                if (contract instanceof ContractTV) {
                    contractInsert.setString(6,"TV Contract");
                    contractInsert.setString(7, Arrays.toString(((ContractTV) contract).getPackageChannel()));
                } else if (contract instanceof ContractMobile) {
                    contractInsert.setString(6,"Mobile Contract");
                    String info = ((ContractMobile) contract).getGbTraffic() + " " + ((ContractMobile) contract).getaMinutes() + " " + ((ContractMobile) contract).getaSMS();
                    contractInsert.setString(7,info);
                } else if (contract instanceof ContractEthernet) {
                    contractInsert.setString(6,"Ethernet Contract");
                    contractInsert.setString(7, String.valueOf(((ContractEthernet) contract).getSpeedConnection()));
                }

                boolean tof = false;
                if (1 == i) {
                    customerInsert.executeUpdate();
                } else {
                    for (int j = 1; j < repository.getAll().length; j++) {
                        if (i != j){
                            if (repository.get(j).getHuman().getId() == (person.getId())) {
                                tof = true;
                            }
                        }
                    }
                    if (!tof){
                        customerInsert.executeUpdate();
                    }
                }

                contractInsert.executeUpdate();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public Repository restoreRepositoryJDBC() {
        Repository repository = new Repository();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement customerStatement = connection.prepareStatement("SELECT * FROM customers");
            ResultSet customerSet = customerStatement.executeQuery();
            PreparedStatement contractStatement = connection.prepareStatement("SELECT * FROM contracts");
            ResultSet contractSet = contractStatement.executeQuery();
            ContractDefault contract = new ContractDefault();

            List<Person> personList = new ArrayList<>();
            while (customerSet.next()) {
                personList.add(new Person(customerSet.getInt(1), customerSet.getString(2),
                        customerSet.getDate(3).toLocalDate(), Gender.valueOf(customerSet.getString(4)), customerSet.getString(5)));
            }
            while (contractSet.next()) {
                for (Person person : personList) {
                    if (contractSet.getInt(5) == person.getId()) {

                        String[] detailedInfo = contractSet.getString(7).split(" ");

                        if (contractSet.getString(6).equals("Mobile Contract")) {
                            contract = new ContractMobile(contractSet.getInt(1), contractSet.getDate(2).toLocalDate(),
                                    contractSet.getDate(3).toLocalDate(), contractSet.getInt(4), person,
                                    Integer.parseInt(detailedInfo[0]), Integer.parseInt(detailedInfo[1]), Integer.parseInt(detailedInfo[2]));

                        } else if (contractSet.getString(6).equals("Ethernet Contract")) {
                            contract = new ContractEthernet(contractSet.getInt(1), contractSet.getDate(2).toLocalDate(),
                                    contractSet.getDate(3).toLocalDate(), contractSet.getInt(4), person, Integer.parseInt(detailedInfo[0]));
                        } else if (contractSet.getString(6).equals("TV Contract")) {
                            contract = new ContractTV(contractSet.getInt(1), contractSet.getDate(2).toLocalDate(),
                                    contractSet.getDate(3).toLocalDate(), contractSet.getInt(4), person, detailedInfo.length, detailedInfo);
                        }
                        repository.add(contract);
                    }
                }

            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return repository;
    }
}
