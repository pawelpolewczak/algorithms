package sorting;

import java.util.Collections;
import java.util.List;

class SelectSort implements Sorting {

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(min).compareTo(list.get(j)) > 0) {
                    min = j;
                }
            }
            Collections.swap(list, i, min);
        }
    }
}
