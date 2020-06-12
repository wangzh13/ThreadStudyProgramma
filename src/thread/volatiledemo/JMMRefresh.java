package thread.volatiledemo;

/**
 * @Description  ：复现情景：不使用volatile关键字，线程之前变量改变，不可见
 * @author       : 王作虎
 */
public class JMMRefresh {

    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            System.out.println("我进到A了");
            while (flag){
                System.out.println("A");
            }
            System.out.println("结束啦");
        }).start();

        Thread.sleep(10000);

        new Thread(()->{
            System.out.println("我进到B了");
            flag = false;
            System.out.println("我出B了");
        }).start();
    }

}
