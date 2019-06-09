package dev.coding.iterator;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class FilteringIteratorTest {

    private static final String TEXT = "The quick brown fox jumps over the lazy dog";

    private String[] tokens;

    @Before
    public void init() {
        tokens = StringUtils.splitByWholeSeparatorPreserveAllTokens(TEXT, StringUtils.SPACE);
    }

    @Test
    public void when_match_filter_then_return() {
        Filter<String> matchFilter = new MatchFilter<>();
        Iterator<String> iterator = Arrays.asList(tokens).iterator();
        Iterator<String> matchIterator = new FilteringIterator<>(iterator, matchFilter);

        assertEquals("fox", matchIterator.next());
        assertFalse(matchIterator.hasNext());
    }

    @Test
    public void when_exclude_filter_then_match() {
        Filter<String> excludeFilter = new ExcludeFilter<>();
        Iterator<String> iterator = Arrays.asList(tokens).iterator();
        Iterator<String> excludeIterator = new FilteringIterator<>(iterator, excludeFilter);

        assertFalse(equals(iterator, excludeIterator));

        List<String> list = new ArrayList<>();
        excludeIterator.forEachRemaining(list::add);

        // Redundant, but shows different uses of Java 8 features
        assertNotEquals(Arrays.asList(tokens), list);
    }

    private static <T, S> boolean equals(Iterator<T> a, Iterator<S> b) {
        while (a.hasNext() && b.hasNext()) {
            if (!a.next().equals(b.next())) {
                return false;
            }
        }
        if (a.hasNext() || b.hasNext()) {
            // one of the iterators has more elements than the other
            return false;
        }
        return true;
    }

    private static final class MatchFilter<T> implements Filter<T> {
        public boolean accept(final T type) {
            return "fox".equals((String) type);
        }
    }

    private static final class ExcludeFilter<T> implements Filter<T> {
        public boolean accept(final T type) {
            return !"the".equalsIgnoreCase((String) type);
        }
    }
}
