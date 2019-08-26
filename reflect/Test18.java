package Review.Test.reflect;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1{
    public String name() default "monekyc";
    public int age() default 22;
}
@Deprecated
@MyAnnotation1
class Member4 implements Serializable{

}

public class Test18 {
    public static void main(String[] args) {
        Annotation[] annotations = Member4.class.getAnnotations();
        for(Annotation ant:annotations){
            System.out.println(ant);
        }
    }
}
