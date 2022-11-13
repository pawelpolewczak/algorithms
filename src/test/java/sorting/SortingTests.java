package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Matchers.isSorted;

class SortingTests {

    private static List<Integer> getRandomListOfIntegers(int size) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt());
        }
        return list;
    }

    private static Stream<List<Integer>> streamOfRandomIntegerLists() {
        return Stream.of(
                new ArrayList<>(List.of(1, 2, 3)),
                new ArrayList<>(List.of(3, 2, 1)),
                new ArrayList<>(List.of(5, 10, 1, 4, 2)),
                new ArrayList<>(List.of(5, 10, 1, 4, 2, 3)),
                SortingTests.getRandomListOfIntegers(10),
                SortingTests.getRandomListOfIntegers(100),
                SortingTests.getRandomListOfIntegers(1000),
                SortingTests.getRandomListOfIntegers(10000)
        );
    }

    @DisplayName("Sorting algorithm sorts randomly generated lists of integers")
    @ParameterizedTest
    @EnumSource(SortingAlgorithms.class)
    void itShouldSortAnArrayOfIntegers(SortingAlgorithms algorithms) {
        streamOfRandomIntegerLists()
                .peek(algorithms.getAlgorithm()::sort)
                .forEach(list -> assertThat(list, isSorted()));
    }
}
