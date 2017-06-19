package Exceptions.handler;

public class ExceptionThread implements Runnable {
 
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by" + t);
        System.out.println("eh=" + t.getUncaughtExceptionHandler());
        throw new RuntimeException("抛出运行时异常--From Thread");
    }
}