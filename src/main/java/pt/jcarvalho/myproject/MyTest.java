package pt.jcarvalho.myproject;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.Atomic.TxMode;

public class MyTest {

    public static void main(String[] args) {
        doIt("x", 1);
    }

    @Atomic(mode = TxMode.WRITE)
    private static void doIt(String x, int i) {
        System.out.println("Doing for :" + x);
    }

}
