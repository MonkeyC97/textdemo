package git.com.Queue;
//两个队列实现栈
public class TestMyStack {
    private MyQueueImpl myQueue1;
    private MyQueueImpl myQueue2;
    private int usdSize;

    public TestMyStack(){
        this.myQueue1 = new MyQueueImpl();
        this.myQueue2 = new MyQueueImpl();
        this.usdSize = 0;
    }

    /** Push element x onto stack. */

    public void push(int x) {
         if(myQueue1.empty() && myQueue2.empty()){
             myQueue1.add(x);                    //如果队列1和队列2都为空，把数据放入队列1(随便放在一个队列里)
         }else if(!myQueue1.empty()){            //如果队列1不为空，将数据放入队列1里面
             myQueue1.add(x);
         }else{
             myQueue2.add(x);                    //如果队列2不为空，将数据放入队列2里面
         }
         this.usdSize++;
    }
    //出栈
    public int pop() {
        if(empty()){
            throw new UnsupportedOperationException("队为空");
        }
        int data = 0;
        if(!myQueue1.empty()){
            while(usdSize - 1 > 0){
                myQueue2.add(myQueue1.poll());
                usdSize--;
            }
            data = myQueue1.poll();
        }else if(!myQueue2.empty()){
            while(usdSize - 1 > 0){
                myQueue1.add(myQueue2.poll());
                usdSize--;
            }
            data = myQueue2.poll();
        }
        return data;
    }
    //获取栈顶元素
    /** Get the top element. */
    public int top() {
        int data = 0;
        if(!myQueue1.empty()){
            for(int i = 0;i < usdSize;i++){
                data = myQueue1.poll();
               myQueue2.add(myQueue1.poll());

            }
        }else{
            for(int i = 0;i < usdSize;i++){
                data = myQueue2.poll();
                myQueue1.add(myQueue2.poll());

            }
        }
       return data;
    }

    public boolean empty() {
        return this.usdSize == 0;
    }

    public int size(){
        return this.usdSize;
    }
}