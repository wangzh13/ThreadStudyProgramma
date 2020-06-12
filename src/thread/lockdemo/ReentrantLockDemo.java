package thread.lockdemo;

/**
 * @Description  ：简单模拟可重入锁
 * @author       : 王作虎
 */
public class ReentrantLockDemo {

    class TestLock{
        private volatile  boolean flag = false;
        private Thread lockThread;
        private  int threadCount;

        public synchronized void lock(){
            Thread thread = Thread.currentThread();
            while (flag&&lockThread!=thread){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = true;
            threadCount++;
            lockThread = thread;
        }
        public synchronized void unlock(){

            if (Thread.currentThread() == lockThread){
                threadCount--;
                if (threadCount==0){
                    flag = false;
                    notify();
                }
            }

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
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        ReentrantLockDemo.TestLock testLock = reentrantLockDemo.new TestLock();
        reentrantLockDemo.testOne(testLock);
    }

}
