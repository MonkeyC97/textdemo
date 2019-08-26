package Review.Test.reflect;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * 取得方法上定义的注解
 */
@SuppressWarnings("serial")
@Deprecated
class MyMember2 implements Serializable{
    @Deprecated
    @Override
    public String toString(){
        return super.toString();
    }
}

public class Test16 {
    public static void main(String[] args) {
        Annotation[] annotations = new Annotation[0];
        try {
            annotations = MyMember2.class.getMethod("toString").getAnnotations();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for(Annotation annotation : annotations){
            System.out.println(annotation);
        }
    }
}
