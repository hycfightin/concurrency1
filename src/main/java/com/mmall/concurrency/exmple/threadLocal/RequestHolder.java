package com.mmall.concurrency.exmple.threadLocal;

//存储线程绑定的信息
public class RequestHolder {
    private final static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    public static  void add (Long id) {
        threadLocal.set(id);
    }
    public static long getId() {
        return  threadLocal.get();
    }
    public static void remove() {
        threadLocal.remove();
    }


}
