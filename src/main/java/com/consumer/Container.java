package com.consumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * @Package: com.consumer
 * @Description: 容器
 * @author: liuxin
 * @date: 2017/7/11 下午5:05
 */
public class Container {
    private Queue<String> queue = new ConcurrentLinkedQueue<String>();

    /**
     * 添加参数，当已经满了了， 当前线程就等待，等到消费者去消费。
     *
     * @param message
     */
    public synchronized void push(String message) {
        while (queue.size() == 5) {
            try {
                this.wait(); //阻塞生产者
                System.out.println("已经装满了");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.notify();
        queue.add(message);
    }

    /**
     * 当已经消费完了，就等待，然后唤醒生产者去消=
     * iooooouihyzAS
     * @return
     */
    public synchronized String pop() {
        //当容器中没有了，就等待
        while (queue.size() == 0) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.notify();//唤醒生产者
        return queue.poll();
    }

}
