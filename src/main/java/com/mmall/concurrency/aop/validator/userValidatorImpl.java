package com.mmall.concurrency.aop.validator;

import com.mmall.concurrency.aop.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class userValidatorImpl implements userValidator{
    @Override
    public boolean validate(User user){
        System.out.println("引入新的接口，"+userValidator.class.getSimpleName());
        return user !=null;
    }
}
