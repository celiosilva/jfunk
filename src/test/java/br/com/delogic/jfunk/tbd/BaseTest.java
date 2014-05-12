package br.com.delogic.jfunk.tbd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;

public class BaseTest extends Assert {

    // TODO escrever comentários em inglês

    protected Random random = new Random();

    public Date getTodayPlus(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    public <E> Collection<E> getObjects(Collection<E> listaObjetos, int qtde) {
        ArrayList<E> lista = new ArrayList<E>();
        if (listaObjetos.size() < qtde) {
            throw new IllegalStateException(
                "Existem menos objetos do que foi o solicitado");
        }

        Set<Integer> indices = new HashSet<Integer>();
        Random r = new Random();
        while (indices.size() != qtde) {
            indices.add(r.nextInt((int) listaObjetos.size() - 1));
        }

        ArrayList<E> objetos = new ArrayList<E>(listaObjetos);
        for (Integer i : indices) {
            lista.add(objetos.get(i));
        }

        return lista;
    }

    public String getNumbers(int qtde) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qtde; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

    public Integer getIntegers(int qtde) {
        return Integer.valueOf(getNumbers(qtde));
    }

    public int getNumber(int from, int to) {
        return (int) (random.nextDouble() * to + from);
    }

    public BigDecimal getBigDecimal(int from, int to) {
        return new BigDecimal(getNumber(from, to));
    }

    public <E extends Object> E getObject(E... values) {
        if (values != null && values.length > 0) {
            return values[random.nextInt(values.length)];
        }
        return null;
    }

    public <E extends Object> E getObjectOrNull(E... values) {
        if (values != null && values.length > 0 && (getBoolean() || getBoolean())) {
            return values[random.nextInt(values.length)];
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <E extends Object> E getObject(Collection<E> col) {
        return (E) getObject(col.toArray());
    }

    public boolean getBoolean() {
        return (random.nextInt() % 2) == 0;
    }

}
