package thread.base;

/**
 * @Description  ：Join方法Demo
 * @author       : 王作虎
 */
public class JoinDemo {

    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是测试线程");
        });
        Thread thread1 = new Thread(()->{
            System.out.println("我是测试线程2");
        });

        thread.start();
        try {
            //1.必须放到start()方法后，才可生效.
            //2.可以通俗理解为插队，
            //3.先执行调用join（）方法的线程，此线程结束后才可执行主线程。也可以这么理解一群人（多个线程）正在排队进行，当某个线程执行了join（）方法后，此线程就插队到主线程之前
            //4.对其余线程无影响
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
        System.out.println("我是主线程");

    }
}
