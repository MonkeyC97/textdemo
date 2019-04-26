package git.com.Stack;
//栈实现队列
public class TestMyQueue {
    private MyStackImpl Stack1;
    private MyStackImpl Stack2;
    private int usedSize;

    public TestMyQueue(int size){
        this.Stack1 = new MyStackImpl(size);
        this.Stack2 = new MyStackImpl(size);
        this.usedSize = 0;
    }
    public TestMyQueue(){
        this.Stack1 = new MyStackImpl(5);
        this.Stack2 = new MyStackImpl(5);
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (Stack1.empty() && Stack2.empty()) {
            throw new UnsupportedOperationException("Stack为空");
        }
        int data = 0;
        if(!Stack2.empty()){
            data = Stack2.pop();
            this.usedSize--;
        }else{
            while(!Stack1.empty()){
                Stack2.push(Stack1.pop());
            }
            data = Stack2.pop();
        }
        return data;
    }

    /** Get the front element. */
    public int peek() {
        if(Stack2.empty() && Stack1.empty()){
            throw new UnsupportedOperationException("Stack为空");
        }
        int data = 0;
        if(!Stack2.empty()){
            data = Stack2.peek();
        }else{
            while(!Stack1.empty()){
                Stack2.push(Stack1.pop());
            }
            data = Stack2.peek();
        }
        return data;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.usedSize == 0;
    }
}
