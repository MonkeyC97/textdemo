package Review.Test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 基础代理模式
 */
interface ISubject{
    void eat();
}

class RealSubject implements ISubject{

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}

class ProxySubject implements ISubject{
    private ISubject subject;

    public ProxySubject(ISubject subject){
        this.subject = subject;
    }

    public void prepare(){
        System.out.println("准备食材，做饭");
    }
    public void after(){
        System.out.println("洗碗");
    }


    @Override
    public void eat() {
        this.prepare();
        this.subject.eat();//核心吃饭
        this.after();
    }
}

class Factory{
    private Factory(){}

    public static <T> T getInstance(String className){
        T t = null;
        try {
            t = (T) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T getInstance(String className,Object obj){
        T t = null;
        try {
            Constructor<?> cons = Class.forName(className).getConstructor(obj.getClass().getInterfaces()[0]);
            t = (T) cons.newInstance(obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        ISubject subject = Factory.getInstance("Review.Test.reflect.ProxySubject",
                Factory.getInstance("Review.Test.reflect.RealSubject"));
            subject.eat();
    }
}
