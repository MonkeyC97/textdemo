package Review.Test.Generic;

/**
 * 类型擦除
 * @param <T>
 */
class MyClass2<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
    public void print(T t){
        System.out.println(t);
    }
}

public class Test9 {
    public static void main(String[] args) {
        MyClass2<String>  myClass1  = new MyClass2<>();
        MyClass2<Integer> myClass2 = new MyClass2<>();
        System.out.println(myClass1.getClass()==myClass2.getClass());
    }
}
