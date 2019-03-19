package Base;

public class YieldTest {

    public static class ReadThread extends Thread {
        int i = 0;

        public void run() {
            while (i < 100) {
                System.out.println("id" + Thread.currentThread().getId() + ":" + i++);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(i + "   currentThread: " + Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        new ReadThread().start();
        new ReadThread().start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}