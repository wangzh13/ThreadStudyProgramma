package thread.volatiledemo;


/**
 * @Description  ：单例模式（饿汉）
 * @author       : 王作虎
 */
public class SingletonPatternOne {

    public static SingletonPatternOne singletonPatternOne = new SingletonPatternOne();

    private  SingletonPatternOne(){

    }
    public static SingletonPatternOne getSingletonPatternOne(){

        return  singletonPatternOne;
    }

}
