package pt.jcarvalho.myproject;

import java.util.stream.IntStream;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.Atomic.TxMode;
import pt.ist.fenixframework.FenixFramework;

public class Main {

    public static void main(String[] args) throws Exception {

        IntStream.range(0, 1000).parallel().forEach(i -> FenixFramework.atomic(() -> {
            createCounter();
        }));

        System.out.println("Created " + FenixFramework.atomic(() -> FenixFramework.getDomainRoot().getCounterSet().size()));

        FenixFramework
                .atomic(() -> {
                    FenixFramework.getDomainRoot().getCounterSet().stream().parallel()
                            .forEach(i -> System.out.println("Counter : " + i));
                });
    }

    @Atomic(mode = TxMode.WRITE)
    private static void createCounter() {
        new Counter();
    }
}
