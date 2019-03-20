package ThreadLocal.inheritable;

import java.util.concurrent.Executors;

public class ThreadLocalPoolTest {
    public static void main(String[] args) {
        ZipkinContext context = ZipkinContext.getContext();
        context.setGlobalTicket("11111");

        Executors.newCachedThreadPool().submit(new Son());
        //new Thread(new Son(), "son").start();
    }

    public static class Son implements Runnable {

        @Override
        public void run() {
            String ticket = ZipkinContext.getContext().getGlobalTicket();
            System.out.println(Thread.currentThread().getName() + ":" + ticket);

            new Thread(new GrandSon(), "grandson").start();
        }
    }

    public static class GrandSon implements Runnable {
        @Override
        public void run() {
            String ticket = ZipkinContext.getContext().getGlobalTicket();
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
        }
    }
}
