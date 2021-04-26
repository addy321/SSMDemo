package com.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.User;
import com.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public List<User> findAll() {
        User user1 = new User();
        user1.setName("张6");
        user1.setPhone("147852");
        user1.setPwd("123654");
        user1.setType(1);
        user1.setCreateTime(new Date());
        List<User> users = userService.findAll();
        return users;
    }

    @RequestMapping(value = "/str", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String str() {
        return "啊啊啊啊啊啊";
    }

    @RequestMapping("/save")
    @ResponseBody
    public boolean saveAccounts() {
        User user1 = new User();
        user1.setName("张6");
        user1.setPhone("147852");
        user1.setPwd("123654");
        user1.setType(1);
        user1.setCreateTime(new Date());

        User user2 = new User();
        user2.setName("张5");
        user2.setPhone("1111147852");
        user2.setPwd("111111123654");
        user2.setType(1);
        user2.setCreateTime(new Date());
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        boolean is = userService.save(users);
        return is;
    }
}
