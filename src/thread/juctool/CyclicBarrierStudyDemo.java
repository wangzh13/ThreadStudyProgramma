package thread.juctool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier类似于闭锁，它能阻塞一组线程直到某个事件的发生。
 * 栅栏与闭锁的关键区别在于，所有的线程必须同时到达栅栏位置，才能继续执行。闭锁用于等待事件，而栅栏用于等待其他线程。
 *
 * CountDownLatch : 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行。
 * CyclicBarrier: N个线程相互等待，任何一个线程完成之前，所有的线程都必须等待。
 * 这样应该就清楚一点了，对于CountDownLatch来说，重点是那个“一个线程”, 是它在等待， 而另外那N的线程在把“某个事情”做完之后可以继续等待，可以终止。
 * 而对于CyclicBarrier来说，重点是那N个线程，他们之间任何一个没有完成，所有的线程都必须等待。
 *
 * @author       : 王作虎
 */
public class CyclicBarrierStudyDemo {
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(10,()->{
        System.out.println("目标达成，冲锋");
    });

    public static void main(String[] args) {

        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {
                    cyclicBarrier.await();//通过调用await方法告知，cyclicBarrier某个线程到达
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
