package Semaphores_12;

import java.util.concurrent.Semaphore;

public class Connectionn {

    private static Connectionn instance = new Connectionn();

    private Semaphore sem = new Semaphore(10, true);

    private Connectionn() {
    }

    public static Connectionn getInstance() {
        return instance;
    }

    public void connect() {
        try {
            // get permit decrease the sem value, if 0 wait for release
            sem.acquire();

            System.out.printf("%s:: 当前可用信号量数 (MAX 10 allowed): %d\n", Thread.currentThread().getName(), sem.availablePermits());

            //do your job
            //System.out.printf("%s:当前线程:...\n", Thread.currentThread().getName());
            Thread.sleep(2000);

            System.out.printf("%s:: 线程释放  剩余可用信号量数 = %d\n", Thread.currentThread().getName(), sem.availablePermits());

        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        } finally {
            //release permit, increase the sem value and activate waiting thread
            sem.release();
        }
    }
}
