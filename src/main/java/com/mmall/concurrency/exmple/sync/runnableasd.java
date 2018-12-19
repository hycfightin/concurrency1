package com.mmall.concurrency.exmple.sync;

public class runnableasd implements  Runnable{

    @Override
    public void run() {
        System.out.println("xiancheng ");
    }
    runnableasd asd = new runnableasd();
    Thread aa = new Thread(asd);
}
