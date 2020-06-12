package thread.base;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description  ：创建线程的第三种方式具体实现
 * @author       : 王作虎
 */
public class FutureTaskDemo {

    public static void main(String[] args) {

        FutureTask<Integer> futureTask = new FutureTask(new CallableDemo());
        //因为FutureTask实现了RunnableFuture接口，RunnableFuture接口继承了Runnable接口
        //所以跟实现Runable接口的方式差不多
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            //这里注明，如果该线程使用时间较长，建议get()放置最后，原因是，如果线程没有计算完毕就调用get(),这里会停滞，直到计算完毕
            //这样建立线程的目的就变了，所以建议放置最后一步使用
             Integer result = futureTask.get();//取出最终返回值
             System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
