package thread.lockdemo;

/**
 * @Description  ：简单模拟不可重入锁
 * @author       : 王作虎
 */
public class NoReentrantLockDemo {

    class TestLock{
        private volatile  boolean flag = false;

        public synchronized void lock(){
            while (flag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = true;
        }
        public synchronized void unlock(){
            flag = false;
            notify();
        }
    }

    public void testOne(TestLock testLock){
        testLock.lock();
        testTwo(testLock);
        testLock.unlock();
    }

    public void testTwo(TestLock testLock){
        testLock.lock();
        System.out.println("woshi 2");
        testLock.unlock();
    }

    public static void main(String[] args) {
        NoReentrantLockDemo reentrantLockDemo = new NoReentrantLockDemo();
        NoReentrantLockDemo.TestLock testLock = reentrantLockDemo.new TestLock();
        reentrantLockDemo.testOne(testLock);
    }

}
