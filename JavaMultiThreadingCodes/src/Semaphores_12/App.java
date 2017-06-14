package Semaphores_12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) { //200 hundred times will be called
            executor.submit(new Runnable() {
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
