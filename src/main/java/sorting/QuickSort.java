package sorting;

import java.util.List;

class QuickSort extends QuickSortAbstract implements Sorting {

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        if (list.size() > 1) {
            quicksort(list);
        }
    }

    @Override
    protected <T extends Comparable<? super T>> void quicksort(List<T> list) {
        quicksort(list, 0, list.size() - 1);
    }

    /**
     * Standard version of quick sort using recursion.
     * First element from left is used as pivot.
     *
     * @param list       list to be sorted
     * @param leftBound  left bound of sorted sublist
     * @param rightBound right bound of sorted sublist
     * @param <T>        elements implementing Comparable interface
     */
    private <T extends Comparable<? super T>> void quicksort(List<T> list, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int pivotIndex = partition(list, leftBound, rightBound);
            if (pivotIndex - 1 > leftBound) quicksort(list, leftBound, pivotIndex - 1);
            if (rightBound > pivotIndex + 1) quicksort(list, pivotIndex + 1, rightBound);
        }
    }
}
