package git.com.Stack;

public class MinStack {
    private MyStackImpl Stack;
    private MyStackImpl minStack;
    private int usedSize = 0;
    public MinStack(){
        this.minStack = new MyStackImpl(5);
        this.Stack = new MyStackImpl(5);

    }
    public MinStack(int size){
        this.minStack = new MyStackImpl(size);
        this.Stack = new MyStackImpl(size);
        this.usedSize = 0;

    }
    public void push(int x) {
       Stack.push(x);
       if(minStack.empty() || x <= minStack.peek()){
           minStack.push(x);
       }
    }

    public int pop() {
        int data = Stack.pop();
        if(minStack.peek() == data){
            minStack.pop();
        }
        return data;
    }

    public int top() {

        return Stack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }

}
