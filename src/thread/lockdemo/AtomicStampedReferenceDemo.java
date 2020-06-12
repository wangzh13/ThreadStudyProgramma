package thread.lockdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {

    public static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,1);

    public static void main(String[] args) {

        new Thread(()->{
            boolean flag = atomicStampedReference.compareAndSet(100,101,1, 2);
            boolean flagOne = atomicStampedReference.compareAndSet(101,100,2, 3);
            System.out.println(Thread.currentThread().getName()+"我成功了吗"+"...."+ flag);
            System.out.println(Thread.currentThread().getName()+"我成功了吗"+"...."+ flagOne);
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int stamp = atomicStampedReference.getStamp();
            boolean flag = atomicStampedReference.compareAndSet(100,101,1, 2);
            System.out.println(Thread.currentThread().getName()+"我成功了吗"+"...."+ flag);
        }).start();
    }

}
