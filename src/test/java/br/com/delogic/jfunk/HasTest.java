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
        assertTrue(Has.content("content"));
        assertFalse(Has.content(" "));
        assertFalse(Has.content(""));
        assertFalse(Has.content(str));
    }

    @Test
    public void testHasContentCollection() {
        Collection<?> collection = null;
        assertTrue(Has.content(Arrays.asList("test")));
        assertFalse(Has.content(collection));
        assertFalse(Has.content(new ArrayList<Integer>()));
    }

    @Test
    public void testHasContentArray() {
        String[] array = null;
        assertTrue(Has.content(new String[] { "teste" }));
        assertFalse(Has.content(new String[] { "" }));
        assertFalse(Has.content(new String[] {}));
        assertFalse(Has.content(array));
    }

    @Test
    public void testHasContentObject() {
        Object str = "";
        assertFalse(Has.content(str));
        Object collection = new HashSet<String>();
        assertFalse(Has.content(collection));
        assertFalse(Has.content((Object) new String[] {}));
        assertFalse(Has.content(new String()));
        assertTrue(Has.content(new Object()));
    }

}
