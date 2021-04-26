package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ssm.entity.User;

@Repository("userDao")
public interface UserDao {

    @Select("select * from a_user")
    public List<User> findAll();

    @Update("INSERT INTO `jdbcproject`.`a_user`(`pwd`, `phone`, `type`, `name`, `createTime`) VALUES (#{pwd}, #{phone}, #{type}, #{name}, #{createTime});")
    public boolean save(User user);
}
