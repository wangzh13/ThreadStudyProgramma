package thread.lockdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description  ：测试tryLock方法
 * @author       : 王作虎
 */
public class TryLockDemo {

    public ReentrantLock reentrantLock = new ReentrantLock();

    public void testOne(){
        if (reentrantLock.tryLock()){
            try{
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我的线程名是"+Thread.currentThread().getName());
            }finally {
                reentrantLock.unlock();
            }
        }
    }
    public void testTwo(){
        boolean flag = false;
        try {
            if (reentrantLock.tryLock(5, TimeUnit.SECONDS)){
                    flag = true;
                    System.out.println("我的线程名是"+Thread.currentThread().getName());
            }else {
                System.out.println("我等了5秒你还没执行完");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (flag){
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        TryLockDemo tryLockDemo = new TryLockDemo();

        new Thread(()->{
            System.out.println("线程A开始执行");
            tryLockDemo.testOne();
        },"AA").start();
        new Thread(()->{
            System.out.println("线程B开始执行");
            tryLockDemo.testOne();
        },"BB").start();
        new Thread(()->{
            System.out.println("线程C开始执行");
            tryLockDemo.testTwo();
        },"CC").start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
