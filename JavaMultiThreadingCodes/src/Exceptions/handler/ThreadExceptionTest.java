package Exceptions.handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadExceptionTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //下面有3中方式来执行线程。
        testSimple();
        testThreadFactory();
    }

    private static void testThreadFactory() {
        //第3种情况一样的，也是走的线程池，但是呢是通过ThreadFactory方式，在ThreadFactory中会对线程做一些控制，可以设置异常处理器
        //此时是可以捕获异常的。
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread());
    }

    private static void testSimple() {
        //第1种按照普通的方式。这时能捕获到异常
        Thread t = new Thread(new ExceptionThread());
        t.setUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
        t.start();
    }

}