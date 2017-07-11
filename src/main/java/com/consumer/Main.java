package com.consumer;

/**
 * @Package: com.consumer
 * @Description: ${todo}
 * @author: liuxin
 * @date: 2017/7/11 下午5:20
 */
public class Main {
    public static void main(String[] args) {

        //创建队列，队列中只能装5个
        Container container = new Container();

        Product product = new Product(container);

        Consumer consumer = new Consumer(container);

        new Thread(product).start();
        new Thread(consumer).start();
    }
}
