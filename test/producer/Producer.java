package test.producer;

import test.Goods.Goods;

import java.util.Queue;

public class Producer implements Runnable{

    private Queue<Goods> queue;
    public Producer(Queue<Goods> queue){
        this.queue = queue;
    }

    public Queue<Goods> getQueue() {
        return queue;
    }

    @Override
    public void run() {
        Goods AllNewBMW3 = new Goods(1,"宝马三系",350000);
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.queue){
                if(this.queue.size() >= 10){
                    System.out.println("容器已满，停止生产，加快消费");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    queue.add(AllNewBMW3);
                }
            }
        }

    }
}
