package com.future;

/**
 * @Package: com.future
 * @Description: 真是返回数据
 * @author: liuxin
 * @date: 2017/7/11 上午10:14
 */
public class RealData implements Data {
    protected String data;

    RealData(String data){
        this.data=data;
    }

    public String getResult() throws InterruptedException {
        return data;
    }
}
