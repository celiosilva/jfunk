package br.com.delogic.jfunk.data;

import org.junit.Assert;
import org.junit.Test;

public class ResultTest extends Assert {

    @Test
    public void testResultCreation() {
        assertNotNull(new Result<String>(""));
        assertNotNull(new Result<String>(new String()));
        assertNotNull(new Result<String>(null));
    }

    @Test
    public void testResultHasValue() {
        assertTrue(new Result<String>("").hasValue());
        assertTrue(new Result<String>(new String()).hasValue());
        assertFalse(new Result<String>(null).hasValue());
    }

    @Test
    public void testGetValueWithNonNull() {
        Result<Integer> result = new Result<Integer>(Integer.MAX_VALUE);
        assertTrue(result.hasValue());
        assertNotNull(result.getValue());
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), result.getValue());
    }

    @Test
    public void testGetValueWithNull() {
        Result<Integer> result = new Result<Integer>(null);
        assertFalse(result.hasValue());
        assertNull(result.getValue());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetValueWithNonNullException() {
        new Result<String>("").getValue();
    }

    @Test(expected = IllegalStateException.class)
    public void testGetValueWithNullException() {
        new Result<String>(null).getValue();
    }

}
