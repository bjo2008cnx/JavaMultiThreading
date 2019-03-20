package ThreadLocal.inheritable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadContext {

    public static ExecutorService pool = Executors.newCachedThreadPool();
}
