package repository;

import contracts.ContractDefault;
import contracts.ContractEthernet;
import contracts.ContractMobile;
import contracts.ContractTV;
import reflection.AutoInjectable;
import sorters.ZISorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Repository model
 */
public class Repository {
    /**
     * array of contracts
     */
    protected ContractDefault[] array;

    /**
     * Sorter repository
     */
    @AutoInjectable
    protected ZISorter sorter;

    /**
     * Constructor repository
     */
    public Repository() {
        this.array = new ContractDefault[0];
    }

    /**
     * Method of add contract in Repository
     * @param element
     * @param <T>
     */
    public <T extends ContractDefault> void add(T element) {
        this.array = Arrays.copyOf(array, array.length + 1);
        this.array[array.length - 1] = element;
    }

    /**
     * Method of delete contract from repository
     * @param id
     */
    public void remove(int id) {
        if (id > 0 && id <= array.length) {
            for (int i=0; i < array.length; i++){
                if (array[i].getId()==id){
                    for (int y = i; y < array.length - 1; ++y) {
                        array[y] = array[y + 1];
                    }
                    this.array = Arrays.copyOf(array, array.length - 1);
                    break;
                }
            }
        }
    }

    /**
     * Method of getting contract from repository
     * @param id
     * @param <T>
     * @return
     */
    public <T extends ContractDefault> T get(int id) {
        for (int i=0; i < array.length; i++){
            if (array[i].getId()==id) {
                return (T) array[i];
            }
        }
        return null;
    }

    public <T extends ContractDefault> T[] getAll() { return (T[]) array; }

    /**
     * Method of find contract in repository
     * @param filter
     * @param <T>
     * @return
     */
    public <T extends ContractDefault> Repository searchByFilter(Predicate<T> filter){
        Repository rep = new Repository();
        boolean bool=false;
        int j=0;
        for (ContractDefault contractDefault : array) {
            if (contractDefault != null && filter.test((T) contractDefault)) {
                rep.add(contractDefault);
                j++;
            }
        }
        if (j!=0) { bool = true; }
        if (bool){
            if (j>1){
                System.out.println("Found " + j + " contracts");}
            if (j==1){
                System.out.println("Found " + j + " contract");
            }
            return rep;
        }
        else {
            System.out.println("No contracts were found for the specified criterion.");
        }
        return rep;
    }

    /**
     * Method that sorts the repository
     * @param cmp
     * @param <T>
     */
    public <T extends ContractDefault> void sortBy(Comparator<T> cmp){
        sorter.sort((T[])array, cmp);
    }

    @Override
    public String toString(){
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof ContractEthernet) {
                System.out.println("Ethernet Contract:\n ID: " + array[i].getId() + ", date of start - date of end contract: " + array[i].getdOfStartContract() + " - " + array[i].getdOfEndContract() + "\n Name of Human: " + array[i].getHuman().getName() + ", Age: " + array[i].getHuman().getAge() + ", Passport: " + array[i].getHuman().getSnPassport() + "\n Speed Connection: " + ((ContractEthernet) array[i]).getSpeedConnection());
            } else if (array[i] instanceof ContractMobile) {
                System.out.println("Mobile Contract:\n ID: " + array[i].getId() + ", date of start - date of end contract: " + array[i].getdOfStartContract() + " - " + array[i].getdOfStartContract() + "\n Name of Human: " + array[i].getHuman().getName() + ", Age: " + array[i].getHuman().getAge() + ", Passport: " + array[i].getHuman().getSnPassport() + "\n Amount of SMS: " + ((ContractMobile) array[i]).getaSMS() + ", amount of Minutes: " + ((ContractMobile) array[i]).getaMinutes() + ", amount of Gb Traffic: " + ((ContractMobile) array[i]).getGbTraffic());
            } else if (array[i] instanceof ContractTV) {
                System.out.println("TV Contract:\n ID: " + array[i].getId() + ", date of start - date of end contract: " + array[i].getdOfStartContract() + " - " + array[i].getdOfEndContract() + "\n Name of Human: " + array[i].getHuman().getName() + ", Age: " + array[i].getHuman().getAge() + ", Passport: " + array[i].getHuman().getSnPassport() + "\n Channels: " + Arrays.toString(((ContractTV) array[i]).getPackageChannel()));
            }
        }
        return null;
    }
}
