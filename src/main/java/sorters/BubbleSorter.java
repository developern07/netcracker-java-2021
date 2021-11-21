package sorters;

import contracts.ContractDefault;

import java.util.Comparator;

/**
 * Bubble sorter model
 */
public class BubbleSorter implements ISorter{
    /**
     * Method of swap elements
     * @param element
     * @param i
     * @param j
     * @param <T>
     */
    protected <T extends ContractDefault> void swap(T[] element, int i, int j){
        T tmp = element[i];
        element[i]=element[j];
        element[j]=tmp;
    }

    /**
     * Method of sort elements
     * @param elements
     * @param cmp
     * @param <T>
     * @return
     */
    public <T extends ContractDefault> T[] sort(T[] elements, Comparator<T> cmp) {
        for (int i = 0; i < elements.length - 1; ++i) {
            for (int j = elements.length - 1; j > i; --j) {
                if (cmp.compare(elements[j-1], elements[j]) > 0) {
                    swap(elements, j-1, j);
                }
            }
        }
        return elements;
    }
}
