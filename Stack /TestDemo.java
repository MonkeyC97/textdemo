package git.com.Stack;

public class TestDemo {
    public static void main(String[] args) {
        MyStackImpl myStack = new MyStackImpl(4);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.isFull());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        TestMyQueue testMyQueue = new TestMyQueue();
    }
}

