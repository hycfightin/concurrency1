package com.mmall.concurrency.aop.aopreal;

import com.mmall.concurrency.aop.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public void printUser(User user) {
        if (user==null) {
            System.out.println("当前用户为空");
        }else {
            System.out.println(
                    user.getId()+user.getNote()+user.getUserName());
        }
    }
}
