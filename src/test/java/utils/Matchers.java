package utils;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;
import java.util.stream.IntStream;

public class Matchers {

    public static <T extends Comparable<? super T>> Matcher<List<T>> isSorted() {
        return new TypeSafeMatcher<>() {
            @Override
            protected boolean matchesSafely(List<T> item) {
                return IntStream.range(0, item.size() - 1)
                        .allMatch(index -> item.get(index).compareTo(item.get(index + 1)) < 0);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Lists are ordered");
            }
        };
    }
}
