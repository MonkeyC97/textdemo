package Review.Test.Generic;

/**
 * 观察泛型上限
 */
class TopClass<T extends Number> {
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

}

public class Test6 {
    public static void main(String[] args) {
        TopClass<Double> topClass = new TopClass<>();
        topClass.setMessage(12.3);
        fun(topClass);
    }
    public static void fun(TopClass<? extends Number> message){
//        message.setMessage(11.3);无法修改
        System.out.println(message.getMessage());
    }

}
