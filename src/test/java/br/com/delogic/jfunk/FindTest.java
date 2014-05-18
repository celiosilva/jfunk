package br.com.delogic.jfunk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindTest extends Assert {

    private List<String>        list;
    private Set<String>         set;
    private Map<String, String> map;
    private Integer[]           integers;

    @Before
    public void init() {
        list = new ArrayList<String>(Arrays.asList("John", "Paul", "Dianno"));
        set = new HashSet<String>(list);
        map = new HashMap<String, String>();
        for (String str : list) {
            map.put(str, str);
        }
        integers = new Integer[] { null, 1, 2, null, 4 };
    }

    @Test
    public void testFindFirst() {
        assertEquals("John", Find.first(list, new When<String>() {
            @Override
            public boolean found(String e) {
                return e.startsWith("J");
            }
        }));

        assertEquals("John", Find.first(list.toArray(new String[list.size()]), new When<String>() {
            @Override
            public boolean found(String e) {
                return e.startsWith("J");
            }
        }));

        assertEquals(Integer.valueOf(1000), Find.first(Arrays.asList(10, 100, 1000), new When<Integer>() {
            @Override
            public boolean found(Integer e) {
                return e > 100;
            }
        }));

        assertEquals(Integer.valueOf(1000), Find.first(new Integer[] { 10, 100, 1000 }, new When<Integer>() {
            @Override
            public boolean found(Integer e) {
                return e > 100;
            }
        }));
    }

    @Test
    public void testFindFirstNullCollection() {
        list.clear();
        Find.first(list, new When<String>() {
            @Override
            public boolean found(String e) {
                fail("should not execute");
                return false;
            }
        });
        Find.first(list.toArray(new String[list.size()]), new When<String>() {
            @Override
            public boolean found(String e) {
                fail("should not execute");
                return false;
            }
        });

        list = null;
        Find.first(list, new When<String>() {
            @Override
            public boolean found(String e) {
                fail("should not execute");
                return false;
            }
        });

        Find.first((String[]) null, new When<String>() {
            @Override
            public boolean found(String e) {
                fail("should not execute");
                return false;
            }
        });
    }

    @Test
    public void testFindFirstNullElements() {
        list.add(null);
        Find.first(list, new When<String>() {
            @Override
            public boolean found(String e) {
                assertNotNull(e);
                return false;
            }
        });

        Find.first(list.toArray(new String[list.size()]), new When<String>() {
            @Override
            public boolean found(String e) {
                assertNotNull(e);
                return false;
            }
        });
    }

    @Test
    public void testFindAllList() {
        List<String> found = Find.all(list, new When<String>() {
            @Override
            public boolean found(String e) {
                return e.contains("a");
            }
        });
        assertNotNull(found);
        assertEquals(2, found.size());
    }

    @Test
    public void testFindAllListNullCollection() {
        list.clear();
        List<String> found = Find.all(list, new When<String>() {
            @Override
            public boolean found(String e) {
                fail("should not execute");
                return true;
            }
        });
        assertNotNull(found);
        assertTrue(found.isEmpty());

        list = null;
        found = Find.all(list, new When<String>() {
            @Override
            public boolean found(String e) {
                fail("should not execute");
                return true;
            }
        });
        assertNotNull(found);
        assertTrue(found.isEmpty());

    }

    @Test
    public void testFindAllListNullElements() {
        list.add(null);
        List<String> found = Find.all(list, new When<String>() {
            @Override
            public boolean found(String e) {
                assertNotNull(e);
                return true;
            }
        });
        assertEquals(3, found.size());
    }

    @Test
    public void testFindAllSet() {
        Set<String> found = Find.all(set, new When<String>() {
            @Override
            public boolean found(String e) {
                return e.contains("a");
            }
        });
        assertNotNull(found);
        assertEquals(2, found.size());
    }

    @Test
    public void testFindAllSetNullCollection() {
        set.clear();
        Set<String> found = Find.all(set, new When<String>() {
            @Override
            public boolean found(String e) {
                fail("should not execute");
                return true;
            }
        });
        assertNotNull(found);
        assertTrue(found.isEmpty());

        set = null;
        found = Find.all(set, new When<String>() {
            @Override
            public boolean found(String e) {
                fail("should not execute");
                return true;
            }
        });
        assertNotNull(found);
        assertTrue(found.isEmpty());

    }

    @Test
    public void testFindAllSetNullElements() {
        set.add(null);
        Set<String> found = Find.all(set, new When<String>() {
            @Override
            public boolean found(String e) {
                assertNotNull(e);
                return true;
            }
        });
        assertEquals(3, found.size());
    }

    @Test
    public void testFindAllMap() {
        Map<String, String> found = Find.all(map, new When<Entry<String, String>>() {
            @Override
            public boolean found(Entry<String, String> e) {
                return e.getValue().contains("a");
            }
        });
        assertNotNull(found);
        assertEquals(2, found.size());
    }

    @Test
    public void testFindAllMapNullCollection() {
        map.clear();
        Map<String, String> found = Find.all(map, new When<Entry<String, String>>() {
            @Override
            public boolean found(Entry<String, String> e) {
                fail("should not execute");
                return true;
            }
        });
        assertNotNull(found);
        assertTrue(found.isEmpty());

        map = null;
        found = Find.all(map, new When<Entry<String, String>>() {
            @Override
            public boolean found(Entry<String, String> e) {
                fail("should not execute");
                return true;
            }
        });
        assertNotNull(found);
        assertTrue(found.isEmpty());

    }

    @Test
    public void testFindAllMapNullElements() {
        map.put(null, null);
        Map<String, String> found = Find.all(map, new When<Entry<String, String>>() {
            @Override
            public boolean found(Entry<String, String> e) {
                assertNotNull(e);
                assertNotNull(e.getKey());
                assertNotNull(e.getValue());
                return true;
            }
        });
        assertEquals(3, found.size());
    }

    @Test
    public void testFindFirstNonNull() {
        assertEquals("John", Find.firstNonNull(list));
        assertEquals(new Integer(1), Find.firstNonNull(integers));
        assertEquals(new Long(3), Find.firstNonNull(null, null, null, null, 3L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstNonNullExNullElements() {
        Find.firstNonNull(new Integer[] {});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstNonNullExNullCollection() {
        Find.firstNonNull((Collection<String>) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstNonNullExNullArray() {
        Find.firstNonNull((String[]) null);
    }

}
