package br.com.delogic.jfunk.tbd;

public interface Convertable<IN, OUT> {

    OUT convert(IN in);

}