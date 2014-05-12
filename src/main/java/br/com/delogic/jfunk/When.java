package br.com.delogic.jfunk;

public abstract class When<E> {

    public abstract boolean found(E e);

    public static final When<String> startsWith(final String with) {
        return new When<String>() {
            @Override
            public boolean found(String e) {
                return Has.content(e) && e.startsWith(with);
            }
        };
    }

}
