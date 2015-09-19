package br.com.delogic.jfunk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Utility to split data according to many different rules
 *
 * @author celio@delogic.com.br
 *
 */
public class Split {

    /**
     * Splits a collection of data into sublists. By using a {@code Iterable} it
     * can be used on foreach loops return sublists of the list selected.
     *
     * @param col
     * @param amount
     * @return
     */
    public static <T> Iterable<List<T>> inSubListsOf(final Collection<T> col, final int amount) {

        return new Iterable<List<T>>() {

            public Iterator<List<T>> iterator() {
                return new Iterator<List<T>>() {

                    private int currentIndex = 0;
                    private final List<T> data = new ArrayList<T>(col);

                    public boolean hasNext() {
                        return data != null && data.size() > currentIndex;
                    }

                    public List<T> next() {
                        int limit = currentIndex + amount > data.size() ? data.size() : currentIndex + amount;
                        List<T> sub = data.subList(currentIndex, limit);
                        currentIndex = limit;
                        return sub;
                    }

                    public void remove() {}
                };
            }
        };
    }
}