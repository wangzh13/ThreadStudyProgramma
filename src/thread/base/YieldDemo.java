package thread.base;

/**
 * @Description  ：yield()方法测试demo
 * @author       : 王作虎
 */
public class YieldDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for(int i = 0; i <= 30; i ++) {
                if(i == 4){
                    Thread.yield();
                }
                System.out.println("线程1"+"我是"+i);
            }
        });
        Thread thread1 = new Thread(()->{
            for(int i = 0; i <= 30; i ++) {
                System.out.println("线程2"+"我不是"+i);
            }
        });
        thread.start();
        thread1.start();
    }
}
