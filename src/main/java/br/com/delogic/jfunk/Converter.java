package br.com.delogic.jfunk;

public interface Converter<In, Out> {

    Out to(In in);

}
