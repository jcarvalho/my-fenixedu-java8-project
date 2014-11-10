package pt.jcarvalho.myproject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import pt.ist.fenixframework.FenixFramework;

public class Main {

    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            service.submit((Runnable) () -> {
                while (true) {
                    FenixFramework.atomic(() -> {
                        for (int j = 0; j < 100; j++) {
                        }
                    });
                }
            });
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);

    }

}
