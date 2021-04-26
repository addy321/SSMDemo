package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import com.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        System.err.println("执行查询方法");
        return userDao.findAll();
    }

    @Override
    public boolean save(List<User> users) {
        boolean is = false;
        for (User user : users) {
            is = userDao.save(user);
            if (!is) {
                break;
            }
        }
        return is;
    }

}
