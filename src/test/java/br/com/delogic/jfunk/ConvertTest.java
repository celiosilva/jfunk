package br.com.delogic.jfunk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.delogic.jfunk.data.Property;

public class ConvertTest extends Assert {

    private List<Person> list;
    private Map<String, Person> map;

    @Test
    public void testConvert() {

        List<String> stringNumber = Arrays.asList("1", "2", "3");

        List<Integer> integers = Convert.from(stringNumber).toListOf(new Converter<String, Integer>() {
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

    public class Person {

        public Person(String name) {
            this.name = name;
        }

        String name;

    }

    @Test
    public void shouldConvertToMap() {
        givenListOfPerson();
        whenConvertinToMap();
        thenReturnAMapOfPersonByName();
    }

    @Test
    public void shouldNotThrowExceptionForEmptyList() {
        list = Collections.<Person> emptyList();
        whenConvertinToMap();
        thenMapIsEmpty();
    }

    @Test
    public void shouldNotThrowExceptionForNullList() {
        list = null;
        whenConvertinToMap();
        thenMapIsEmpty();
    }

    private void thenMapIsEmpty() {
        assertNotNull(map);
        assertTrue(map.isEmpty());
    }

    private void givenListOfPerson() {
        list = new ArrayList<Person>();
        list.add(new Person("John"));
        list.add(new Person("Adam"));
        list.add(new Person("King"));
    }

    private void whenConvertinToMap() {
        map = Convert.from(list).toMapOf(new Converter<Person, Property<String, Person>>() {
            public Property<String, Person> to(Person in) {
                return new Property<String, ConvertTest.Person>(in.name, in);
            }
        });
    }

    private void thenReturnAMapOfPersonByName() {
        assertTrue(!map.isEmpty());
        assertTrue(map.containsKey("John"));
        assertTrue(map.containsKey("Adam"));
        assertTrue(map.containsKey("King"));
    }

}
