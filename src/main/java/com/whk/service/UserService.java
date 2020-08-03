package com.whk.service;

import com.whk.entity.User;

import java.util.List;

public interface UserService {

    //查询所有用户
    List<User> findAll();

    //保存用户
    void save(User user);

    //根据id删除一个用户
    void delete(String id);

    //根据id查询一个用户
    User findOne(String id);

    //修改用户信息
    void update(User user);

    //模糊搜索
    List<User> findNameOrPhoneCode(String name,String code);
}
