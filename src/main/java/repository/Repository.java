package repository;

import contracts.ContractDefault;

import java.util.Arrays;

public class Repository {

    protected ContractDefault[] array;

    public Repository() {
        this.array = new ContractDefault[0];
    }

    public <T extends ContractDefault> void add(T element) {
        this.array = Arrays.copyOf(array, array.length + 1);
        this.array[array.length - 1] = element;
    }

    public <T extends ContractDefault> T get(int id) {
        for (int i=0; i < array.length; i++){
            if (array[i].getId()==id) {
                return (T) array[i];
            }
        }
        return null;
    }
}
