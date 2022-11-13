package sorting;

import java.util.Collections;
import java.util.List;

class BubbleSort implements Sorting {

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        int numberOfSwaps;
        do {
            numberOfSwaps = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    Collections.swap(list, i, i + 1);
                    numberOfSwaps++;
                }
            }
        } while (numberOfSwaps != 0);
    }
}
