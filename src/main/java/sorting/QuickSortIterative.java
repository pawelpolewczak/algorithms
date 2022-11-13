package sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class QuickSortIterative extends QuickSortAbstract implements Sorting {

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        if (list.size() > 1) {
            quickSortIterative(list, new LinkedList<>());
        }
    }

    /**
     * Iterative version of quick sort. Instead of using stack for return points of recursive method calls, pairs of
     * integers is placed on FIFO queue. Pair of integers represent longer sublist which was a result of previous
     * called partitioning operation. Smaller sublist is taken to be processed immediately in next iteration without
     * putting it on stack.
     *
     * @param list  list to be sorted
     * @param stack FIFO queue for putting sublist range parameters for later processing
     * @param <T>   elements implementing Comparable interface
     */
    private <T extends Comparable<? super T>> void quickSortIterative(List<T> list, Queue<IntegerPair> stack) {
        stack.offer(new IntegerPair(0, list.size() - 1));
        while (!stack.isEmpty()) {
            IntegerPair pair = stack.poll();
            int left = pair.left();
            int right = pair.right();
            while (left < right) {
                int pivotIndex = partition(list, left, right);
                if (pivotIndex - left > right - pivotIndex) {
                    stack.offer(new IntegerPair(pivotIndex + 1, right));
                    right = pivotIndex - 1;
                } else {
                    stack.offer(new IntegerPair(left, pivotIndex - 1));
                    left = pivotIndex + 1;
                }
            }

        }
    }

    @Override
    protected <T extends Comparable<? super T>> void quicksort(List<T> list) {
        quickSortIterative(list, new LinkedList<>());
    }
}
