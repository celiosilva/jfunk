package br.com.delogic.jfunk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class HasTest extends Assert {

    @Test
    public void testHasContentString() {
        String str = null;
        assertTrue(has.content("content"));
        assertFalse(has.content(" "));
        assertFalse(has.content(""));
        assertFalse(has.content(str));
    }

    @Test
    public void testHasContentCollection() {
        Collection<?> collection = null;
        assertTrue(has.content(Arrays.asList("test")));
        assertFalse(has.content(collection));
        assertFalse(has.content(new ArrayList<Integer>()));
    }

    @Test
    public void testHasContentArray() {
        String[] array = null;
        assertTrue(has.content(new String[] { "" }));
        assertFalse(has.content(new String[] {}));
        assertFalse(has.content(array));
    }

    @Test
    public void testHasContentObject() {
        Object str = "";
        assertFalse(has.content(str));
        Object collection = new HashSet<String>();
        assertFalse(has.content(collection));
        assertFalse(has.content((Object) new String[] {}));
        assertFalse(has.content(new String()));
        assertTrue(has.content(new Object()));
    }

}
