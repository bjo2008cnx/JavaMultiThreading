package Join;

/**
 * JoinDemo
 *
 * @author Michael.Wang
 * @date 2017/6/15
 */
public class JoinWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        joinx();
    }

    private static void joinx() throws InterruptedException {
        JoinDemoThread demo = new JoinDemoThread();
        long start = System.currentTimeMillis();
        demo.start();
        demo.join(1); //等待1ms,时间到之后如果线路程未执行完就不等了
        System.out.println("Thread isAlive: "+demo.isAlive());
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("joined.");
    }

}