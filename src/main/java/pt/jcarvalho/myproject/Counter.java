package pt.jcarvalho.myproject;

import pt.ist.fenixframework.Atomic;

public class Counter extends Counter_Base {

    public Counter() {
        super();
    }

    @Atomic
    public int inc() {
        int val = getValue() + 1;
        setValue(val);
        return val;
    }

    public boolean predicate() {
        return getValue() < 1000;
    }

}
