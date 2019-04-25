package git.com.Stack;

public class TestDemo {
    public static void main(String[] args) {
        MyStackImpl myStack = new MyStackImpl(10);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        System.out.println(myStack.pop());//40
        System.out.println(myStack.peek());//30
        myStack.push(50);
        System.out.println(myStack.peek());//50
        System.out.println(myStack.pop());//50

        System.out.println(myStack.pop());//30
        System.out.println(myStack.pop());//20
        System.out.println(myStack.pop());//10
        System.out.println(myStack.pop());
    }
}

