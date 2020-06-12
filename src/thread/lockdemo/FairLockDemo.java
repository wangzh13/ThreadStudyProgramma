package thread.lockdemo;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockDemo {

    /**
     * 此场景模拟要素
     * 线程内多次使用共同资源（要点，不可一直占用，需要断断续续的进行使用，模拟二者抢夺），模拟两个线程相互抢夺资源，观察结果
     */

    public ReentrantLock reentrantLock = new ReentrantLock(true);

    public void testOne(){
        for(int i=0;i<100;i++){
            try{
                reentrantLock.lock();//线程1与线程2有
                System.out.println(Thread.currentThread().getName()+"................."+i);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                reentrantLock.unlock();
            }

        }
    }
    public static void main(String[] args) {

        FairLockDemo fairLockDemo = new FairLockDemo();
        new Thread(()->{
            fairLockDemo.testOne();
        },"AA").start();

        new Thread(()->{
            fairLockDemo.testOne();
        },"BB").start();
    }

}
