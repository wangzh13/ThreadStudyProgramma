package thread.volatiledemo;

/**
 * @Description  ：volatile关键字不保证原子性情景复现
 * @author       : 王作虎
 */
public class AtomicDemo {

    public volatile static Integer testCount = 0;

    public  void addGo(){
        for (int i = 0; i < 10000; i++) {
            testCount++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        /**
         * 出现这种情况的原因主要是  testCount++; 这条语句，分三个步骤进行
         * （可以观看后边讲解 testCount++ 这句代码在JVM当中具体是怎么执行的知识，同时学习一下相关字节码指令的知识，了解详细相关指令操作）
         * 类似这三步进行，如下
         *
         * int i = testCount //操作1
         * i = i+1 //操作2
         * testCount = i //操作3
         *
         * 出现上述情况的缘由（举例说明）是，刚开始线程1占用cpu资源，当testCount = 8887 时 线程1执行完毕操作2（testCount = 8888），正准备回写时，
         * 线程2抢夺cpu资源成功，线程1 停滞，线程2又从开始执行，从 testCount = 8887 开始执行，等执行到 testCount = 9700时，线程1开始执行， 回写刚刚的 8888
         * 这时线程2刚刚做的工作全部无用功。
         */


        AtomicDemo atomicDemo = new AtomicDemo();

        new Thread(()->{
            atomicDemo.addGo();
        }).start();

        new Thread(()->{
            atomicDemo.addGo();
        }).start();

        Thread.sleep(10000);
        //正确打印值应该为20000，但是因为volatile不保证原子性，所以会出现别的情况
        System.out.println(testCount);
    }


}
