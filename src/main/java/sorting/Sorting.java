package sorting;

import java.util.List;

public interface Sorting {

    <T extends Comparable<? super T>> void sort(List<T> list);
}
