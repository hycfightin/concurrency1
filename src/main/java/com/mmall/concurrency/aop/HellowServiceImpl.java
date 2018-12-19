package com.mmall.concurrency.aop;

import org.springframework.stereotype.Service;

@Service
public class HellowServiceImpl implements  HellowService{

    @Override
    public void sayHellow(String name) {
        if (name==null || name.trim().equals("")){
            throw new RuntimeException("param is null");
        }
        System.out.println("hellow" +name);
    }
}
