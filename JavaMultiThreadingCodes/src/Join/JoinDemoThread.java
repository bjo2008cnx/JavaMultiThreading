package Join;

/**
 * JoinDemoThread
 *
 * @author Michael.Wang
 * @date 2017/6/15
 */
public class JoinDemoThread extends Thread {

    public void run() {
        try {
            System.out.println("demo start：" + Thread.currentThread().getId());
            Thread.sleep(1000);
            System.out.println("demo end：" + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}