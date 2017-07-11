package com.consumer;

/**
 * @Package: com.consumer
 * @Description:从队列中获取参数
 * @author: liuxin
 * @date: 2017/7/11 下午5:20
 */
public class Consumer implements Runnable {
    Container container;

    Consumer(Container container) {
        this.container = container;
    }

    public void run() {
        for(int i=1; i<20; i++) { //一共要吃20个
            try { //生成一个睡1秒，便于观察
                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费了：" + container.pop());
        }
    }
}
