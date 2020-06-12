package thread.lockdemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    public ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    public ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    public ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    public void readData(){
        try{
            readLock.lock();
            System.out.println(Thread.currentThread().getName()+"我获得了锁");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+"我读完数据了了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }

    }
    public void writeData(){
        try{
            writeLock.lock();
            System.out.println(Thread.currentThread().getName()+"我获得了锁");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"我写完数据了了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
    public static void main(String[] args) {

        ReentrantReadWriteLockDemo reentrantReadWriteLockDemo = new ReentrantReadWriteLockDemo();



        new Thread(()->{
            reentrantReadWriteLockDemo.readData();
        },"读锁1").start();

        new Thread(()->{
            reentrantReadWriteLockDemo.writeData();
        },"写锁").start();
        new Thread(()->{
            reentrantReadWriteLockDemo.readData();
        },"读锁2").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
