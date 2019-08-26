package Review.Test.reflect;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * 取得定义在类上的注解
 */
@SuppressWarnings("serial")
@Deprecated
class MyMember implements Serializable{

}
public class Test15 {
    public static void main(String[] args) {
        Annotation[] annotations = MyMember.class.getAnnotations();
        for(Annotation ant:annotations){
            System.out.println(ant);
        }
    }
}
