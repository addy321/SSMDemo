package com.ssm.service;

import java.util.List;

import com.ssm.entity.User;

public interface UserService {
    /**
     * 查询用户集合
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 批量保存用户
     *
     * @param users
     */
    public boolean save(List<User> users);
}
