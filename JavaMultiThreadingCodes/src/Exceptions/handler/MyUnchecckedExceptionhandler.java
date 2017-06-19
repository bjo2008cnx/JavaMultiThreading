package Exceptions.handler;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 用于捕获异常---捕获的是uncheckedException
 * 
 * @author February30th
 * 
 */
public class MyUnchecckedExceptionhandler implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("在MyUnchecckedExceptionhandler中捕获到异常：" + e);
    }

}