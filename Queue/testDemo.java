package git.com.Queue;

public class testDemo {
    public static void main(String[] args) {
        MyQueueImpl myQueue = new MyQueueImpl();
        System.out.println(myQueue.empty());
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.empty());
    }
}
