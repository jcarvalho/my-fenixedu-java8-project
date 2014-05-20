package pt.jcarvalho.myproject;

public class Counter extends Counter_Base {

    public Counter() {
        super();
    }

    public void inc() {
        setValue(getValue() + 1);
    }

}
