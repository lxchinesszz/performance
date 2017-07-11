package com.future;

/**
 * @Package: com.future
 * @Description: 异步返回，主要使用逻辑，就是当数据为准备好就线程等待，准备好就返回
 * @author: liuxin
 * @date: 2017/7/11 上午10:16
 */
public class FutureData implements Data {
    RealData realData = null;

    boolean isReady = false;//是否已经准备好

    public synchronized void setRealData(RealData realData){
        //如果已经好了，就直接返回
        if (isReady){
            return;
        }
        this.realData=realData;
        isReady=true;
        notifyAll();//唤醒线程，准备返回参数
    }

    public String getResult() throws InterruptedException {
        //没有准备好久等待
        if (!isReady) {
            wait();
        }
        return realData.getResult();
    }
}
