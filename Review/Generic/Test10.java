package Review.Test.Generic;

import java.lang.reflect.Field;

class MyClass3<T extends String,E>{
    private T message;
    private E text;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public E getText() {
        return text;
    }

    public void setText(E text) {
        this.text = text;
    }
    public void print(T t,E e){
        System.out.println(t);
        System.out.println(e);
    }
}

public class Test10 {
    public static void main(String[] args) {
        MyClass3<String,Integer> myClass3 = new MyClass3<>();
        Class cls = myClass3.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getType());
        }
    }
}
