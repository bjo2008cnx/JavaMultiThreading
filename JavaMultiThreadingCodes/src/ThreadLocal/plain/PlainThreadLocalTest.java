package ThreadLocal.plain;

import ThreadLocal.inheritable.ZipkinContext;

public class PlainThreadLocalTest {
    public static void main(String[] args) {
        PlainZipkinContext context = PlainZipkinContext.getContext();
        context.setGlobalTicket("11111");

        new Thread(new Child()).start();
        new Thread(new Child()).start();
    }

    public static class Child implements Runnable {

        @Override
        public void run() {
            String ticket = ZipkinContext.getContext().getGlobalTicket();
            System.out.println(Thread.currentThread().getId() + ":" + ticket);
        }
    }
}
