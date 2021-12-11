import functions.CSVLoader;
import org.junit.Test;
import repository.Repository;

public class exercise3 {
    @Test
    public void readCSV() throws Exception {
        Repository contracts = new Repository();
        CSVLoader reader = new CSVLoader();
        reader.readAndParseCSV("src/main/resources/data.csv", contracts);
        contracts.toString();
    }
}
