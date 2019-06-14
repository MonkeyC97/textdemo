package test.consumer;

import test.common.Goods;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<Goods> queue;
    public Consumer(Queue<Goods> queue){
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
                    System.out.println(Thread.currentThread().getName()+"库存为空，加快生产");
                    this.queue.notifyAll();
                }else{
                    Goods goods = this.queue.poll();
                    if (goods != null) {
                        System.out.println(Thread.currentThread().getName() + " 消费商品 " + goods);
                    }
                }
            }
        }
    }
}
