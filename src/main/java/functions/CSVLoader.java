package functions;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import contracts.ContractEthernet;
import contracts.ContractMobile;
import contracts.ContractTV;
import entities.Person;
import helpers.Gender;
import repository.Repository;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CSVLoader {

    /**
     * Method of reading data from a file and writing this data to a repository
     * @throws Exception
     */
    public void readAndParseCSV(String file, Repository contracts) throws Exception
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Person human;
        CSVParser pars = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();
        CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(pars).withSkipLines(0).build();
        String[] nextLine;
        int personId = 1;
        int numberString = 1;
        String typeOfContract;
        Person[] humansArray = new Person[personId];
        while ((nextLine = reader.readNext()) != null) {
            human = new Person(personId, nextLine[2], LocalDate.parse(nextLine[4], format), Gender.valueOf(nextLine[3]), nextLine[5]);
            for (int i=0; i<personId-2; i++){
                if (humansArray[i] == human){
                    human.setId(i+1);
                    personId--;
                    break;
                }
                else {
                    humansArray = Arrays.copyOf(humansArray, humansArray.length + 1);
                    humansArray[humansArray.length - 1] = human;
                }
            }
            typeOfContract=nextLine[6];
            String[] addInfo = nextLine[7].split(", ");
            switch (typeOfContract){
                case ("Ethernet") -> {
                    int speed = Integer.parseInt(nextLine[7]);
                    contracts.add(new ContractEthernet(numberString, LocalDate.parse(nextLine[0], format), LocalDate.parse(nextLine[1], format), numberString, human, speed));
                }
                case ("Mobile") -> {
                    contracts.add(new ContractMobile(numberString, LocalDate.parse(nextLine[0], format), LocalDate.parse(nextLine[1], format), numberString, human, Integer.parseInt(addInfo[0]), Integer.parseInt(addInfo[1]), Integer.parseInt(addInfo[2])));
                }
                case ("TV") -> {
                    contracts.add(new ContractTV(numberString, LocalDate.parse(nextLine[0], format), LocalDate.parse(nextLine[1], format), numberString, human, addInfo.length-1, addInfo));
                }
            }
            numberString++;
            personId++;
        }
    }
}
