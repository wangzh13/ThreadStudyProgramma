package thread.juctool;

import java.util.concurrent.Semaphore;

/**
 * Semaphore(信号量)：是一种计数器，用来保护一个或者多个共享资源的访问。如果线程要访问一个资源就必须先获得信号量。
 * 如果信号量内部计数器大于0，信号量减1，然后允许共享这个资源；
 * 否则，如果信号量的计数器等于0，信号量将会把线程置入休眠直至计数器大于0.当信号量使用完时，必须释放。
 *
 * @author: 王作虎
 */
public class SemaphoreStudyDemo {

    public Semaphore semaphore = new Semaphore(5);

    public void userSem(){
        try {
            semaphore.acquire();//从信号量获取一个许可，如果无可用许可前将一直阻塞等待，
            System.out.println("我的线程是："+Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();//释放一个许可
        }
    }

    public static void main(String[] args) {

        SemaphoreStudyDemo semaphoreStudyDemo = new SemaphoreStudyDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                semaphoreStudyDemo.userSem();
            }).start();
        }

    }

}
