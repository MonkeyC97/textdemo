package Review.Test.reflect;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义一个Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    public String name();
    public int age();
}

@Deprecated
@MyAnnotation(name="monkeyc",age = 22)
class Member3 implements Serializable{

}

public class Test17 {
    public static void main(String[] args) {
        Annotation[] annotations = new Annotation[0];
        annotations = Member3.class.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }
}
