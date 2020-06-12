package thread.volatiledemo;

/**
 * @Description  ：单例模式（懒汉）
 * @author       : 王作虎
 */
public class SingletonPatternTwo {

    public static SingletonPatternTwo singletonPatternTwo = null;

    private SingletonPatternTwo(){

    }
    public static SingletonPatternTwo getSingletonPatternOne(){

        if (singletonPatternTwo==null){
            singletonPatternTwo = new SingletonPatternTwo();
        }

        return  singletonPatternTwo;
    }

}
