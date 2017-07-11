package com.future.built;

import java.util.concurrent.Callable;

/**
 * @Package: com.future.built
 * @Description: ${todo}
 * @author: liuxin
 * @date: 2017/7/11 上午11:26
 */
public class RealData implements Callable<String> {

    private String data;

    RealData(String data){
        this.data=data;
    }

    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(data);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
        return sb.toString();
    }
}
