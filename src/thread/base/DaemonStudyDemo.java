package thread.base;

/**
 * @Description  ：守护线程demo
 * @author       : 王作虎
 */
public class DaemonStudyDemo {
    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            System.out.println("这是一条守护线程");
        });
        //在线程启动之前编写thread.setDaemon(true);这条语句，就可以设置线程为守护线程
        thread.setDaemon(false);//false 为不是守护线程，如果不编写此语句则默认用户线程
        thread.start();
    }
}
