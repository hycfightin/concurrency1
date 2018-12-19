package com.mmall.concurrency.exmple.sync;

public class threads extends  Thread{
    private static  int x = 1;
    public void run() {
        System.out.print("线程开始啦"+x);
        x++;
    }


    public static void main(String[] args) {
        threads aaa = new threads();
        threads BBB = new threads();
        aaa.start();
        BBB.start();
    }

}
