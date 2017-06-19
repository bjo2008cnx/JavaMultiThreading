package Exceptions.handler;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println("创建一个新的线程");
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
        System.out.println("exception handler = " + t.getUncaughtExceptionHandler());
        return t;
    }

}