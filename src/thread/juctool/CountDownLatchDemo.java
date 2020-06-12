package thread.juctool;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。
 *
 *    三个线程A B C D
 *    线程A必须等待BCD三个线程执行完，才可执行
 *
 * @author       : 王作虎
 */
public class CountDownLatchDemo {
    public static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程已经执行完了");
        },"AA").start();
        new Thread(()->{
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+"线程已经执行完了");
        },"BB").start();
        new Thread(()->{
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+"线程已经执行完了");
        },"CC").start();
        new Thread(()->{
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+"线程已经执行完了");
        },"DD").start();

    }

}
