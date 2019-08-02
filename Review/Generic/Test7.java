package Review.Test.Generic;

/**
 * 设置泛型下限
 */

class Lowest<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}


public class Test7 {
    public static void main(String[] args) {
        Lowest<String> lowest = new Lowest<>();
        lowest.setMessage("hello");
        fun(lowest);
    }

    public static void fun(Lowest<? super String> message){
        message.setMessage("world");//可以修改
        System.out.println(message.getMessage());
    }
}
