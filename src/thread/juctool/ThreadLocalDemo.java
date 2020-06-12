package thread.juctool;

/**
 * @Description  ：ThreadLocal将某些共享变量变更为线程私有变量，这样来实现线程安全（比较霸道，把原本共享资源变成自己私有的）
 * @author       : 王作虎
 */
public class ThreadLocalDemo {

    public static ThreadLocal threadLocal = new ThreadLocal();

    public static String name = "王作虎";

    public static void main(String[] args) {

        new Thread(()->{
            threadLocal.set(name);
        }).start();

        new Thread(()->{
            threadLocal.get();
            System.out.println(threadLocal.get());
        }).start();
    }


}
