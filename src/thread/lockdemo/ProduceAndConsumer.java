package thread.lockdemo;

import java.util.ArrayList;

/**
 * @Description  ：使用synchronizeed 关键字，结合object的 wait与notify实现
 * @author       : 王作虎
 */
public class ProduceAndConsumer {

    public static ArrayList<String> list = new ArrayList<>();
    public boolean flag = true;
    public final Integer MAX_NUM = 10;

    public void producer(){
        while (flag){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (list){
                while (list.size()==MAX_NUM){ // 这个地方不可以用if，是因为object的wait方法，在哪里停下就会在哪里运行，如果是if，执行一次就不会再次执行了
                    try {                // 如果有其他线程使用notify唤醒此线程，如果是if不会判断当前是否生产满了，直接就按照生产未满进行执行
                        System.out.println("仓库已经放不下了，请开始消费");
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    list.add("1");
                    list.notify();//通知开始消费
                    System.out.println("produce number:" + list.get(0) + "\t" + "current size:" + list.size());
            }
        }
    }
    public void consumer(){
        while (flag){

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            synchronized (list){

                while (list.size()==0){
                    try {
                        System.out.println("请尽快开始生产");
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    String temp = list.get(0);
                    list.remove(0);
                    list.notify();//通知开始生产
                    System.out.println("cousume number:" + temp + "\t" + "current size:" + list.size());

            }
        }
    }

    public void stop() { //停止生产者消费者模型
        flag = false;
    }

    public static void main(String[] args) {

        ProduceAndConsumer produceAndConsumer = new ProduceAndConsumer();
        new Thread(()->{
            produceAndConsumer.producer();
        }).start();
        new Thread(()->{
            produceAndConsumer.consumer();
        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        produceAndConsumer.stop();
    }


}
