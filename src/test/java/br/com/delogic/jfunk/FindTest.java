package br.com.delogic.jfunk;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.delogic.jfunk.find.when;

public class FindTest extends Assert {

    @Test
    public void testFindFirst() {

        List<String> list = Arrays.asList("John", "Paul", "Dianno");

        assertEquals("John", find.first(list, when.startsWith("J")));

    }
}
