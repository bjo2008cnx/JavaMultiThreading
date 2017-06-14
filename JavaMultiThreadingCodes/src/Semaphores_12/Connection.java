package Semaphores_12;

import java.util.concurrent.Semaphore;

public class Connection {

    private static Connection instance = new Connection();

    private Semaphore sem = new Semaphore(10, true);
    private int connections = 0;

    private Connection() {
    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {

            // get permit decrease the sem value, if 0 wait for release
            sem.acquire();

            //if doConnect throws and exception is still releases the permit
            //so we use a separate method here to increase the connections count
            doConnect();

        } catch (InterruptedException ignored) {
        } finally {
            //release permit, increase the sem value and activate waiting thread
            sem.release();
        }
    }

    public void doConnect() {
        synchronized (this) { //atomic
            connections++;
            //System.out.println("当前连接数 (max 10 allowed): " + connections);
            System.out.printf("%s:: 当前可用信号量数 (MAX 10 allowed): %d\n", Thread.currentThread().getName(), sem.availablePermits());
        }
        try {
            //do your job
           // System.out.println("当前线程" + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}

        //when exit doConnect method decrement number of connections
        synchronized (this) {//atomic
            connections--;
            //System.out.println("" + Thread.currentThread().getName() + " 已完成，连接释放 , 当前连接数: " + connections);
            System.out.printf("%s:: 线程释放  剩余可用信号量数 = %d\n", Thread.currentThread().getName(), sem.availablePermits());
        }
    }
}
