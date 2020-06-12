package thread.lockdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description  ：简单模拟手写自旋锁
 * @author       : 王作虎
 */
public class SpinLockDemo {

    /**
     * 自旋锁实际上就是让线程执行一个忙循环（自旋），不停的去访问查看锁是否已经被释放。
     */

    public volatile static AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){

        System.out.println(Thread.currentThread().getName()+"尝试开始加锁");
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)){//atomicReference.compareAndSet() 返回值为布尔类型，当另一个线程想尝试加锁时
                                                                   //会一直执行CAS，不停的访问查看锁是否被释放
        }
        System.out.println(Thread.currentThread().getName()+"加锁成功");
    }

    public void unlock(){

        Thread thread = Thread.currentThread();
        boolean flag = atomicReference.compareAndSet(thread,null);
        if (flag){
            System.out.println(Thread.currentThread().getName()+"解锁");
        }
    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(()->{
            spinLockDemo.lock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unlock();
        },"AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinLockDemo.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unlock();
        },"BB").start();
    }
}
