package sorters;

import contracts.ContractDefault;

import java.util.Comparator;
import java.util.Random;

/**
 * Quick sorter model
 */
public class QuickSorter implements ISorter {

    /**
     * Random value
     */
    private static final Random RND = new Random();

    @Override
    public <T extends ContractDefault> T[] sort(T[] element, Comparator<T> cmp) {
        qsort(element, 0, element.length - 1, cmp);
        return element;
    }

    /**
     * Method of quick sort
     * @param element
     * @param begin
     * @param end
     * @param cmp
     * @param <T>
     */
    private <T extends ContractDefault> void qsort(T[] element, int begin, int end, Comparator<T> cmp) {
        if (end > begin) {
            int index = partition(element, begin, end, cmp);
            qsort(element, begin, index - 1, cmp);
            qsort(element, index + 1, end, cmp);
        }
    }

    /**
     * Method of partition
     * @param element
     * @param begin
     * @param end
     * @param cmp
     * @param <T>
     * @return
     */
    private <T extends ContractDefault> int partition(T[] element, int begin, int end, Comparator<T> cmp) {
        int index = begin + RND.nextInt(end - begin + 1);
        T pivot = element[index];
        swap(element, index, end);
        for (int i = index = begin; i < end; ++i) {
            if (cmp.compare(element[i], pivot) <= 0) {
                swap(element, index++, i);
            }
        }
        swap(element, index, end);
        return (index);
    }

    /**
     * Method of swap elements
     * @param element
     * @param i
     * @param j
     * @param <T>
     */
    private <T extends ContractDefault> void swap(T[] element, int i, int j) {
        T tmp = element[i];
        element[i] = element[j];
        element[j] = tmp;
    }
}
