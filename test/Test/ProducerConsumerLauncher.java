package test.Test;

import test.common.Goods;
import test.consumer.Consumer;
import test.producer.Producer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerLauncher {
    public ProducerConsumerLauncher(){

    }

    public static void run(int producers, int consumers){

        System.out.println("生产者：" + producers + " 消费者：" + consumers);
        Queue<Goods> queue = new LinkedList<>();
        Runnable produce = new Producer(queue);
        Runnable consumer = new Consumer(queue);
        //生产者线程
        for (int i = 0; i < producers; i++) {
            new Thread(produce, "生产者-" + i).start();
        }
        //消费者线程
        for (int i = 0; i < consumers; i++) {
            new Thread(consumer, "消费者-" + i).start();
        }
    }
}
