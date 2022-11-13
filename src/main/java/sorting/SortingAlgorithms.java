package sorting;

public enum SortingAlgorithms {

    BUBBLE_SORT(new BubbleSort()),
    INSERT_SORT(new InsertSort()),
    SELECT_SORT(new SelectSort()),
    QUICK_SORT(new QuickSort()),
    QUICK_SORT_IT(new QuickSortIterative());

    private final Sorting algorithm;

    SortingAlgorithms(Sorting algorithm) {
        this.algorithm = algorithm;
    }

    public Sorting getAlgorithm() {
        return algorithm;
    }
}
