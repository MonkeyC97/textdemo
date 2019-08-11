package Review.Test.Generic;

class Message<T> {
    private T message;

    public void setMessage(T message) {
        this.message = message;
    }
    public T getMessage(){
        return message;
    }
}


public class Test5 {
    public static void main(String[] args) {
        Message<String> message = new Message();
        message.setMessage("hello world");
        fun(message);
    }

    public static void fun(Message<?> message){
        System.out.println(message.getMessage());
    }
}
//public class Test5{
//    public static void main(String[] args) {
//        Message<Integer> message = new Message<>();
//        message.setMessage(100);
//        fun(message);
//    }
//
//    public static void fun(Message<String> message){
//        System.out.println(message.getMessage());
//    }
//}
