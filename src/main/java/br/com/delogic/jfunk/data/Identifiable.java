package br.com.delogic.jfunk.data;

/**
 * This interface marks an object as identifiable so you can trust there's an
 * unique Id to separate amont other objects.
 *
 * @author celio@delogic.com.br
 *
 * @since 15/05/2014
 * @param <E>
 *            Any type
 */
public interface Identifiable<E> {

    /**
     * Returns id for identification. Must never return null.
     *
     * @return a non null valid object for identification
     */
    E getId();

}
