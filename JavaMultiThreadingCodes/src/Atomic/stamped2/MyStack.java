package Atomic.stamped2;

/**
 * AtomicStampedRefTest
 *
 * @author Michael.Wang
 * @date 2017/6/19
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class MyStack<T> {
    //initialStamp = 0
    AtomicStampedReference<Node<T>> head = new AtomicStampedReference<>(null, 0);

    public void push(T value) {
        Node<T> node = new Node<>(value);
        push(node);
    }

    public void push(Node<T> node) {
        for (; ; ) {
            Node<T> tmpHead = head.getReference();
            int stamp = head.getStamp();
            if (head.compareAndSet(tmpHead, node, stamp, stamp + 1)) {
                node.setNext(tmpHead);
                return;
            }
        }
    }

    public Node<T> pop() {
        for (; ; ) {
            Node<T> node = head.getReference();
            int stamp = head.getStamp();
            if (node == null) {
                return null;
            }
            Node<T> nextNode = node.getNext();

            // add this sleep to cause ABA problem
            if (Thread.currentThread().getName().equals("Thread1")) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (head.compareAndSet(node, nextNode, stamp, stamp + 1)) {
                return node;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> node = head.getReference();
        while (node != null) {
            sb.append(node.getValue());
            if (node.getNext() != null) {
                sb.append(",");
            }
            node = node.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

}