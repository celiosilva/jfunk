package br.com.delogic.jfunk;

import java.util.Collection;

public class find {

    public static abstract class when<E> {

        public abstract boolean found(E e);

        public static when<String> startsWith(final String with) {
            return new when<String>() {
                @Override
                public boolean found(String e) {
                    return has.content(e) && e.startsWith(with);
                }
            };
        }

    }

    public static <E> E first(Collection<? extends E> from, when<E> when) {
        for (E e : from) {
            if (e != null && when.found(e)) {
                return e;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <E, C extends Collection<E>> C all(C col, when<E> when) {
        C newCol = (C) instantiate(col.getClass());
        for (E e : col) {
            if (when.found(e)) {
                newCol.add(e);
            }
        }
        return newCol;
    }

    private static <T> T instantiate(Class<T> type) {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Impossible to create this object:" + type, e);
        }
    }

}
