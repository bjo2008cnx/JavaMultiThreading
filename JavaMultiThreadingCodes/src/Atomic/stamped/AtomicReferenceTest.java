package Atomic.stamped;// AtomicReferenceTest.java的源码

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 带时间戳的对象无锁测试
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        // 创建两个Person对象，它们的id分别是101和102。
        Person p1 = new Person(101, "Wang");
        Person p2 = new Person(102, "Li");

        // 新建AtomicReference对象，初始化它的值为p1对象
        AtomicStampedReference ar = new AtomicStampedReference(p1, 0);
        // 通过CAS设置ar。如果ar的值为p1的话，则将其设置为p2。
        ar.compareAndSet(p1, p2, 0, 1);

        Person p3 = (Person) ar.getReference();
        System.out.println("p3 is " + p3);
        System.out.println("p3.equals(p1)=" + p3.equals(p1));
    }
}

class Person {
    volatile long id;
    volatile String name;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "id:" + id;
    }
}