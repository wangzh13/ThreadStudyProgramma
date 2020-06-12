package thread.lockdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class ABADemo {

    public static AtomicInteger atomicInteger = new AtomicInteger(100);

    /**
     * ABA 问题其实就相当于，狸猫换太子，只看到了最后结果，中间做了什么并不知道，如下。模拟ABA
     */
    public static void main(String[] args) {

        new Thread(()->{
            boolean flag = atomicInteger.compareAndSet(100,101);
            boolean flagOne = atomicInteger.compareAndSet(101,100);
            System.out.println(Thread.currentThread().getName()+"我成功了吗"+"...."+ flag);
            System.out.println(Thread.currentThread().getName()+"我成功了吗"+"...."+ flagOne);
        }).start();
        new Thread(()->{
            boolean flag = atomicInteger.compareAndSet(100,101);
            System.out.println(Thread.currentThread().getName()+"我成功了吗"+"...."+ flag);
        }).start();
    }
}
