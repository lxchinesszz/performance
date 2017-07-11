package com.consumer;

/**
 * @Package: com.consumer
 * @Description: 添加资料
 * @author: liuxin
 * @date: 2017/7/11 下午5:18
 */
public class Product implements Runnable {
    Container container;

    Product(Container container) {
        this.container = container;
    }

    public void run() {
        for (int i = 1; i < 20; i++) { //一共要生成20个
            String wt = i + "馒头";
            container.push(wt);
            System.out.println("生产了：" + wt);
            try { //生成一个睡1秒，便于观察
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
