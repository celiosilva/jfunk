package br.com.delogic.jfunk;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ConvertTest extends Assert {

    @Test
    public void testConvert() {

        List<String> stringNumber = Arrays.asList("1", "2", "3");

        List<Integer> integers = convert.from(stringNumber).toListOf(new Converter<String, Integer>() {
            public Integer to(String in) {
                return Integer.valueOf(in);
            }
        });

        Find.first(Arrays.asList(""), new When<String>() {

            @Override
            public boolean found(String e) {
                // TODO Auto-generated method stub
                return false;
            }
        });
    }
}
