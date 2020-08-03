package com.whk.dao;

import com.whk.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {

    //查询所有
    List<User> findAll();

    //保存用户
    void save(User user);

    //根据id删除用户信息
    void delete(String id);

    //根据id查询一个用户
    User findOne(String id);

    //修改用户信息
    void update(User user);

    //根据姓名或者电话进行模糊查询
    List<User> findNameOrPhoneCode(@Param("name") String name,@Param("code") String phoneCode);
}
