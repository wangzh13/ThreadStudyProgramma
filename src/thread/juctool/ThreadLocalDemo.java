package thread.juctool;

/**
 * @Description  ：复制共享变量的值(引用类型存值，基本类型存值)存入ThreadLocal，作为ThreadLocal所属线程自己的本地变量，修改值的话通过set方法进行操作，这个本地变量是自己的，别人不可访问
 * @author       : 王作虎
 */
public class ThreadLocalDemo {

    public static ThreadLocal threadLocal = new ThreadLocal();

    public static String name = "王作虎";

    public static void main(String[] args) {

        new Thread(()->{
            threadLocal.set(name);
            threadLocal.set(name = "ss");
            name = "ss";
        }).start();

        new Thread(()->{
            threadLocal.get();
            System.out.println(threadLocal.get());
            System.out.println(name);
        }).start();
    }


}
