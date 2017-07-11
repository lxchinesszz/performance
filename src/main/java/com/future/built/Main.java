package com.future.built;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Package: com.future.built
 * @Description: 内置方法
 * 将任务交给线程去提交执行
 * @author: liuxin
 * @date: 2017/7/11 上午11:27
 */
public class Main {
    public static void main(String[] args) throws Exception{
        FutureTask<String> future=new FutureTask<String>(new RealData("2"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(future);
        executor.shutdown();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println(future.get());


    }
}
