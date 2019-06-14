package test.producer;

import test.common.Goods;

import java.util.Queue;
import java.util.Random;
import java.util.UUID;

public class Producer implements Runnable{

    private Queue<Goods> queue;
    public Producer(Queue<Goods> queue){
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
                if(this.queue.size() >= 10){
                    System.out.println("容器已满，停止生产，加快消费");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    String id = UUID.randomUUID().toString();
                    String name = "AllNew宝马325Li";
                    Double price = new Random().nextDouble();
                    Goods goods = new Goods(id,name,price);
                    System.out.println(Thread.currentThread().getName() + " 生产商品 " + goods);
                    queue.add(goods);
                }
            }
        }

    }
}
