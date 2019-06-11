package test.consumer;

import test.Goods.Goods;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<Goods> queue;
    public Consumer(Queue<Goods> queue){
        this.queue = queue;
    }

    public  Queue<Goods> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Goods> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.queue){
                if(this.queue.size() == 0){
                    System.out.println("库存为空，加快生产");
                    notifyAll();
                }else{
                    queue.poll();
                }
            }
        }
    }
}
