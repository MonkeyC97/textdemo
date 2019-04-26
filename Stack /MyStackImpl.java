package git.com.Stack;

public class MyStackImpl implements IMyStack {

    private int top;//永远指向可以存放数据元素的下标
    private int[] elem;//数组
    private int usedSize;//数据元素的个数


    public MyStackImpl(int size) {
        this.top = 0;
        this.elem = new int[size];
        this.usedSize = 0;
    }
    //判断栈是否为满
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    //入栈
    @Override
    public void push(int item) {
       if(isFull()){
           throw new UnsupportedOperationException("栈为满");
       }
       this.elem[top++] = item;
       this.usedSize++;
    }
    //返回栈顶元素，并且出栈
    @Override
    public int pop() {
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        int data = this.elem[top - 1];
        top--;
        this.usedSize--;
        return data;
    }
    //查看栈顶元素不出栈
    @Override
    public int peek() {
        if (empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        return this.elem[top - 1];
    }
    //判断栈是否为空
    @Override
    public boolean empty() {
        return this.top == 0;
    }
    //返回栈元素的个数
    @Override
    public int size() {
        return this.usedSize;
    }
}
