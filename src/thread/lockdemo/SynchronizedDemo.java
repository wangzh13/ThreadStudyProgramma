package thread.lockdemo;

public class SynchronizedDemo {

    public synchronized void testOne(){
        System.out.println("同步方法");
    }
    public void testTwo(){
        synchronized (this){
            System.out.println("同步代码块");
        }
    }
    public static void main(String[] args) {

    }
}
