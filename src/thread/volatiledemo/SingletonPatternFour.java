package thread.volatiledemo;

/**
 * @Description  ：单例模式（懒汉）(Holder模式)
 * @author       : 王作虎
 */
public class SingletonPatternFour {

    private SingletonPatternFour(){

    }

    private static class getSingletonPatternClass {
        //静态内部类的加载不需要依附外部类，在使用时才加载。不过在加载静态内部类的过程中也会加载外部类
        private  static SingletonPatternFour singletonPatternTwo = new SingletonPatternFour();
    }

    public static SingletonPatternFour getSingletonPatternOne(){
        return  getSingletonPatternClass.singletonPatternTwo;
    }

}
