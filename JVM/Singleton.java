package Review.Test.JVM;

/**
 * 饿汉单例模式
 */
public class Singleton {
    private static Singleton singleton  = new Singleton();//饿汉单例模式
    private Singleton(){}
    public static  Singleton getInstance(){
        return singleton;
    }
}
