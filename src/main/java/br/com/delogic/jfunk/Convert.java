package br.com.delogic.jfunk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.delogic.jfunk.data.Property;

public class Convert {

    @SuppressWarnings("unchecked")
    public static final <In, C extends Collection<In>> Convertible<In> from(C collection) {
        Convertible<In> convertible = new Convertible<In>();
        if (Has.content(collection)) {
            convertible.data = (In[]) collection.toArray();
        }
        return convertible;
    }

    public static class Convertible<In> {

        private In[] data;

        public <Out> List<Out> toListOf(final Converter<In, Out> converter) {
            final List<Out> list = new ArrayList<Out>();
            ForEach.element(data, new Each<In>() {
                public void each(In e, int index) {
                    list.add(converter.to(e));
                }
            });
            return list;
        }

        public <Out> Set<Out> toSetOf(final Converter<In, Out> converter) {
            final Set<Out> set = new HashSet<Out>();
            ForEach.element(data, new Each<In>() {
                public void each(In e, int index) {
                    set.add(converter.to(e));
                }
            });
            return set;
        }

        public <A, Out> Map<A, Out> toMapOf(final Converter<In, Property<A, Out>> converter) {
            final Map<A, Out> map = new HashMap<A, Out>();
            ForEach.element(data, new Each<In>() {
                public void each(In e, int index) {
                    Property<A, Out> po = converter.to(e);
                    map.put(po.getId(), po.getValue());
                }
            });
            return map;
        }

    }

}
