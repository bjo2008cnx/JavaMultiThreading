package ThreadLocal.inheritable;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ZipkinContext context = ZipkinContext.getContext();
        context.setGlobalTicket("11111");

        new Thread(new Son(), "son").start();
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
