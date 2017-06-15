package Join;

/**
 * JoinDemo
 *
 * @author Michael.Wang
 * @date 2017/6/15
 */
public class JoinDemo extends Thread {

    public void run() {
        try {
            System.out.println("demo start：" + Thread.currentThread().getId());
            Thread.sleep(1000);
            System.out.println("demo end：" + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        joinx();
        //join0();
    }

    private static void joinx() throws InterruptedException {
        JoinDemo demo = new JoinDemo();
        long start = System.currentTimeMillis();
        demo.start();
        demo.join(1); //等待1ms,时间到之后如果线路程未执行完就不等了
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("joined.");
    }

    private static void join0() throws InterruptedException {
        JoinDemo demo = new JoinDemo();
        long start = System.currentTimeMillis();
        demo.start();
        demo.join(0); //等待1ms,时间到之后如果线路程未执行完就不等了
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("joined.");
    }
}