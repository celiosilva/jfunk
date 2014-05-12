package br.com.delogic.jfunk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForEachTest extends Assert {

    private List<String> strs;
    private String[] array;

    @Before
    public void init() {
        strs = new ArrayList<String>(Arrays.asList("1", "2", "3", "4"));
        array = new String[]{"1", "2", "3", "4"};
    }

    @Test
    public void testForEachCollection() {
        ForEach.element(strs, new Each<String>() {
            public void each(String e, int index) {
                assertNotNull(e);
                assertEquals(String.valueOf(index + 1), e);
            }
        });
    }

    @Test
    public void testForEachNullCollection() {
        strs.clear();
        ForEach.element(strs, new Each<String>() {
            public void each(String e, int index) {
                fail("should never execute");
            }
        });

        strs = null;
        ForEach.element(strs, new Each<String>() {
            public void each(String e, int index) {
                fail("should never execute");
            }
        });
    }

    @Test
    public void testForEachNullElement() {
        strs.add(null);
        ForEach.element(strs, new Each<String>() {
            public void each(String e, int index) {
                assertNotNull(e);
            }
        });
    }

    @Test
    public void testForEachRemoval() {
        ForEach.element(strs, new Each<String>() {
            public void each(String e, int index) {
                if (e.equals("3")) {
                    strs.remove(e);
                }
            }
        });

        assertEquals(3, strs.size());
    }

    @Test
    public void testForEachIndex() {
        final Set<Integer> amount = new HashSet<Integer>();
        ForEach.element(strs, new Each<String>() {
            public void each(String e, int index) {
                amount.add(index);
            }
        });

        assertEquals(4, amount.size());
        Integer index = 0;
        for (Integer amt : amount) {
            assertEquals(index++, amt);
        }
    }

    @Test
    public void testForEachArray() {
        ForEach.element(array, new Each<String>() {
            public void each(String e, int index) {
                assertNotNull(e);
                assertEquals(String.valueOf(index + 1), e);
            }
        });
    }

    @Test
    public void testForEachNullArray() {
        for (int i = 0; i < array.length; i++){
            array[i] = null;
        }
        ForEach.element(array, new Each<String>() {
            public void each(String e, int index) {
                fail("should never execute");
            }
        });

        array = null;
        ForEach.element(array, new Each<String>() {
            public void each(String e, int index) {
                fail("should never execute");
            }
        });
    }

    @Test
    public void testForEachArrayNullElement() {
        array = new String[]{null};
        ForEach.element(strs, new Each<String>() {
            public void each(String e, int index) {
                assertNotNull(e);
            }
        });
    }

    @Test
    public void testForEachArrayIndex() {
        final Set<Integer> amount = new HashSet<Integer>();
        ForEach.element(array, new Each<String>() {
            public void each(String e, int index) {
                amount.add(index);
            }
        });

        assertEquals(4, amount.size());
        Integer index = 0;
        for (Integer amt : amount) {
            assertEquals(index++, amt);
        }
    }


}
