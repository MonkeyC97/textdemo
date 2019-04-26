package git.com.Queue;

public class MyQueueImpl implements IMyQueue {

    class Node{
        private Node next;
        private int data;
        public Node(int data){
            this.data = data;
        }
    }
    private Node front;
    private Node rear;
    private int usdSize;
    public MyQueueImpl(){
        this.front = null;
        this.rear = null;
        this.usdSize = 0;
    }
    //判断队列是否为空
    @Override
    public boolean empty() {
        return this.usdSize == 0;
    }
    //返回队首元素但不出队列
    @Override
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }
    //返回队首元素并且出队列
    @Override
    public int poll() {
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int data = this.front.data;
        if(this.usdSize == 1){
            this.front = null;
            this.rear = null;
        }else{
            this.front = this.front.next;
        }
        this.usdSize--;
        return data;
    }

    @Override
    public void add(int item) {
    Node node = new Node(item);
    if(this.usdSize == 0){
        this.front = node;
        this.rear = node;
    }else{
        this.rear.next = node;
        this.rear = this.rear.next;
     }
    this.usdSize++;
    }

    @Override
    public int size() {
        return this.usdSize;
    }
}
