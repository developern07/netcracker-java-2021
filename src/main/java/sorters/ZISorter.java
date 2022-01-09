package sorters;

import contracts.ContractDefault;

import java.util.Comparator;

/**
 * Sorter interface
 */
public interface ZISorter {
    public <T extends ContractDefault> T[] sort (T[] element, Comparator<T> cmp);
}
