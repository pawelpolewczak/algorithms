package sorting;

import java.util.List;

class InsertSort implements Sorting {

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T variable = list.get(i);
            int j = i;
            while (j > 0 && variable.compareTo(list.get(j - 1)) < 0) {
                j--;
            }
            list.remove(variable);
            list.add(j, variable);
        }
    }
}
