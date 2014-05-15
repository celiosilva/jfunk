package br.com.delogic.jfunk.data;

import org.junit.Assert;
import org.junit.Test;

public class IdentityTest extends Assert {

    public static class MyIdentifiableObject extends Identity<Long> {

        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    }

    public static class AnotherIdentifiableObject extends MyIdentifiableObject {

    }

    @Test
    public void testInheritance() {
        MyIdentifiableObject id = new MyIdentifiableObject();
        assertTrue(Identifiable.class.isAssignableFrom(id.getClass()));
    }

    @Test
    public void testGettersSetters() {

        MyIdentifiableObject id = new MyIdentifiableObject();
        id.setId(1L);
        assertNotNull(id.getId());
        assertTrue(Identifiable.class.isAssignableFrom(id.getClass()));
        assertEquals("Type:br.com.delogic.jfunk.data.IdentityTest$MyIdentifiableObject id:1", id.toString());
        assertNotNull(id.hashCode());
        assertEquals(1, id.hashCode());

    }

    @Test
    public void testEquality() {

        MyIdentifiableObject id = new MyIdentifiableObject();
        id.setId(1L);
        assertNotNull(id.getId());

        MyIdentifiableObject other = new MyIdentifiableObject();

        other.setId(new Long(1));
        assertTrue(id.equals(other));

        other.setId(1L);
        assertTrue(id.equals(other));

        other.setId(10001L);
        assertFalse(id.equals(other));

        AnotherIdentifiableObject another = new AnotherIdentifiableObject();
        another.setId(id.getId());
        assertEquals(id.getId(), another.getId());
        assertFalse(id.equals(another));
        assertFalse(id.equals(""));
        assertFalse(id.equals(null));

    }

}
