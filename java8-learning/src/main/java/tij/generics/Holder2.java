package tij.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaocaiwen on 2017/3/17.
 */
public class Holder2<T> {
    private List<T> elements;

    public Holder2(T a,T b, T c) {
        if(elements==null) {
            elements = new ArrayList<T>();
        }
        elements.add(a);
        elements.add(b);
        elements.add(c);
    }

    public List<T> getElements() {
        return elements;
    }
}
