package thread.base;

import java.util.concurrent.Callable;

/**
 * @Description  ：第三种线程创建方式，对接Callable接口
 * @author       : 王作虎
 */
public class CallableDemo implements Callable<Integer> {//<>括号内可以放置一个返回值类型，不放置则为Object

    @Override
    public Integer call() throws Exception {
        return 100;
    }
}
