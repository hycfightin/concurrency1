package com.mmall.concurrency.aop;

public class testmain {
    public static void main(String[] args) {
        testproxy();
    }
    private static void testproxy() {
        HellowService hellowService = new HellowServiceImpl();
        HellowService proxy = (HellowService)ProxyBean.getProxyBean(hellowService,new MyInterceptor());
        proxy.sayHellow("caonima");
        System.out.println("\n______________________________________\n");
        proxy.sayHellow(null);
    }

}
