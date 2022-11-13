package sorting;

import java.util.Collections;
import java.util.List;

abstract class QuickSortAbstract {

    protected abstract <T extends Comparable<? super T>> void quicksort(List<T> list);

    protected <T extends Comparable<? super T>> int partition(List<T> list, int leftBound, int rightBound) {
        T pivot = list.get(leftBound);
        int fromLeftIndex = leftBound + 1;
        int fromRightIndex = rightBound;
        do {
            while (list.get(fromLeftIndex).compareTo(pivot) < 0 && fromLeftIndex < rightBound) fromLeftIndex++;
            while (list.get(fromRightIndex).compareTo(pivot) > 0) fromRightIndex--;
            if (fromLeftIndex < fromRightIndex) {
                Collections.swap(list, fromLeftIndex, fromRightIndex);
            }
        } while (fromLeftIndex < fromRightIndex);

        Collections.swap(list, leftBound, fromRightIndex);
        return fromRightIndex;
    }

    protected record IntegerPair(Integer left, Integer right) {
    }
}
