import contracts.ContractDefault;
import functions.CSVLoader;
import org.junit.Test;
import reflection.Injector;
import repository.Repository;

import java.util.Comparator;

public class exercise5 {
    @Test
    public void testReflectionForSorter() throws Exception {
        Injector injector = new Injector();
        Repository contracts = new Repository();
        CSVLoader reader = new CSVLoader();
        reader.readAndParseCSV("src/main/resources/data.csv", contracts);
        injector.inject(contracts);
        contracts.sortBy(Comparator.comparingInt((ContractDefault c) -> c.getdOfStartContract().getYear()));
        contracts.toString();
    }

    @Test
    public void testReflectionForCSVReader() throws Exception {
        Injector injector1 = new Injector();
        Repository contracts = new Repository();
        CSVLoader reader = new CSVLoader();
        injector1.inject(reader);
        reader.readAndParseCSV("src/main/resources/data.csv", contracts);
    }
}
