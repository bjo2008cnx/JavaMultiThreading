package Atomic.stamped2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * AtomicStampedReferenceTest
 *
 * @author Michael.Wang
 * @date 2017/6/19
 */
public class AtomicStampedReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        final MyStack<String> stack = new MyStack<>();
        stack.push("B");
        stack.push("A");
        System.out.println("Stack init:" + stack);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread1");
                stack.pop();
                System.out.println("Thread1 pop :" + stack);
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread2");
                Node<String> A = stack.pop();
                System.out.println("Thread2 pop :" + stack);
                stack.pop();
                System.out.println("Thread2 pop :" + stack);
                stack.push("D");
                System.out.println("Thread2 push D:" + stack);
                stack.push("C");
                System.out.println("Thread2 push C:" + stack);
                stack.push(A);
                System.out.println("Thread2 push A:" + stack);
            }
        });
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Stack result:" + stack);
    }
}