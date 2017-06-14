package LockObjects_4;

/**
 * 这两个例子说明：尽量不要在方法上加说明 ，如果有两个方法都加了synchroinzed,两个方法会相互影响
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Synchronized Objects: ");
        Worker worker = new Worker();
        worker.main();
        System.out.println("Synchronized Methods: ");
        WorkerMethodsSynchronized worker2 = new WorkerMethodsSynchronized();
        worker2.main();
    }
}
