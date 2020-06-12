package thread.lockdemo;


import java.util.concurrent.locks.ReentrantLock;

public class LockinterruptiblyDemo {

    public ReentrantLock reentrantLock = new ReentrantLock();
    private volatile boolean flag = true;

    public void testOne(){
        if (reentrantLock.tryLock()){

            if (flag){
                flag = false;
            }else {
                flag = true;
            }//这里是为了判断线程2是否需要解锁，线程1执行完，flag为false，线程2如果得到锁进行执行则，flag为true

            try{
                try {
                    Thread.sleep(5000);
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
        try {
            reentrantLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (flag){
                reentrantLock.unlock();
            }
        }
    }
    public static void main(String[] args) {

        LockinterruptiblyDemo lockinterruptiblyDemo = new LockinterruptiblyDemo();

        new Thread(()->{
            System.out.println("线程B开始执行");
            lockinterruptiblyDemo.testOne();
        },"BB").start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       Thread thread = new Thread(()->{
            System.out.println("线程C开始执行");
            lockinterruptiblyDemo.testTwo();
        },"CC");

        thread.start();

        thread.interrupt();
    }

}
