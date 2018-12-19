package com.mmall.concurrency.aop.controller;

import com.mmall.concurrency.aop.aopreal.UserService;
import com.mmall.concurrency.aop.pojo.User;
import com.mmall.concurrency.aop.validator.userValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser() {
        User user = new User();
        user.setId("1");
        user.setNote("caonima");
        user.setUserName("lss");
        userService.printUser(user);
        return user;
    }
    @RequestMapping("/vp")
    @ResponseBody
    public  User validateAndPrint(String  id,String userName,String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);
        user.setId(id);
        userValidator userValidator = (userValidator)userService;
        if (userValidator.validate(user)){
            userService.printUser(user);
        }
        return  user;
    }
}
