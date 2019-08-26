package Review.Test.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 用注解的形式配置工厂类
 */

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    public Class<?> target();
}
interface IFruit{
    public void eat();
}
class Apple implements IFruit{

    @Override
    public void eat() {
        System.out.println("吃桃");
    }
}
@MyAnnotation3(target = Apple.class)

class Factory1{
    public static <T> T getInstance() throws Exception{
        MyAnnotation3 mt = Factory1.class.getAnnotation(MyAnnotation3.class);
        return (T) mt.target().newInstance();
    }
}

public class Test19 {
    public static void main(String[] args) throws Exception {
        IFruit fruit = Factory1.getInstance();
        fruit.eat();
    }
}
