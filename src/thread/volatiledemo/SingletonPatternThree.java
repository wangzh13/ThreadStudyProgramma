package thread.volatiledemo;

/**
 * @Description  ：单例模式（懒汉）(双重加锁检查DCL（Double Check Lock）)
 * @author       : 王作虎
 */
public class SingletonPatternThree {

    public volatile static SingletonPatternThree singletonPatternTwo = null;

    private SingletonPatternThree(){

    }
    public static SingletonPatternThree getSingletonPatternOne(){
        
        if (singletonPatternTwo==null){
            synchronized (SingletonPatternThree.class){
                if (singletonPatternTwo == null){
                    singletonPatternTwo = new SingletonPatternThree();
                }
            }
        }

        return  singletonPatternTwo;
    }

}
