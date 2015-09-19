package br.com.delogic.jfunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SplitTest extends Assert {

    private ArrayList<Integer> list;
    private Iterable<List<Integer>> iterable;
    private Iterator<List<Integer>> iterator;
    private int sublistsAmout;
    private ArrayList<List<Integer>> sublists;

    @Test
    public void shouldSplitSmallerList() {
        givenListOfIntsSizedAt(10);
        whenSplittingInSublistsOf(20);
        thenReturnedSublistsAre(1);
        thenSizesReturnedAre(10);

        givenListOfIntsSizedAt(1);
        whenSplittingInSublistsOf(20);
        thenReturnedSublistsAre(1);
        thenSizesReturnedAre(1);

        givenListOfIntsSizedAt(19);
        whenSplittingInSublistsOf(20);
        thenReturnedSublistsAre(1);
        thenSizesReturnedAre(19);

        givenListOfIntsSizedAt(0);
        whenSplittingInSublistsOf(20);
        thenReturnedSublistsAre(0);
        thenSizesReturnedAre();
    }

    @Test
    public void shouldSplitSameSizeListAsSplit() {
        givenListOfIntsSizedAt(20);
        whenSplittingInSublistsOf(20);
        thenReturnedSublistsAre(1);
        thenSizesReturnedAre(20);
    }

    @Test
    public void shouldSplitBiggerSizeList() {
        givenListOfIntsSizedAt(21);
        whenSplittingInSublistsOf(20);
        thenReturnedSublistsAre(2);
        thenSizesReturnedAre(20,1);

        givenListOfIntsSizedAt(100);
        whenSplittingInSublistsOf(20);
        thenReturnedSublistsAre(5);
        thenSizesReturnedAre(20,20,20,20,20);

        givenListOfIntsSizedAt(101);
        whenSplittingInSublistsOf(20);
        thenReturnedSublistsAre(6);
        thenSizesReturnedAre(20,20,20,20,20,1);
    }

    private void thenSizesReturnedAre(int... i) {
        int index = 0;
        for (int j : i) {
            assertEquals(j, sublists.get(index++).size());
        }
    }

    private void givenListOfIntsSizedAt(int i) {
        list = new ArrayList<Integer>();
        for (int j = 0; j < i; j++) {
            list.add(j);
        }
    }

    private void whenSplittingInSublistsOf(int i) {
        iterable = Split.inSubListsOf(list, i);
        sublistsAmout = 0;
        iterator = iterable.iterator();
        sublists = new ArrayList<List<Integer>>();
        while (iterator.hasNext()) {
            sublistsAmout++;
            assertTrue(sublists.add(iterator.next()));
        }
    }

    private void thenReturnedSublistsAre(int i) {
        assertEquals(sublistsAmout, i);
    }

}
