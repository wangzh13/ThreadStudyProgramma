package thread.lockdemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProduceAndConsumerThree {

    public BlockingQueue blockingQueue = new ArrayBlockingQueue(5);
    public boolean flag = true;


    public void producer(){
        while (flag){
            try {
                blockingQueue.put(1);
                System.out.println("生产者队列"+blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void consumer(){
        while (flag){
            try {
                blockingQueue.take();
                System.out.println("消费者"+blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() { //停止生产者消费者模型
        flag = false;
    }

    public static void main(String[] args) {

        ProduceAndConsumerThree produceAndConsumerThree = new ProduceAndConsumerThree();
        new Thread(()->{
            produceAndConsumerThree.producer();
        }).start();
        new Thread(()->{
            produceAndConsumerThree.consumer();
        }).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        produceAndConsumerThree.stop();
    }
}
