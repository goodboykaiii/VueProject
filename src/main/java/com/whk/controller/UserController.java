package com.whk.controller;

import com.alibaba.druid.util.StringUtils;
import com.whk.entity.User;
import com.whk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //查询所有方法
    @GetMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
    }

    //保存用户方法
    @PostMapping("/save")
    public Map<String,Object> save(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        try {
            if(StringUtils.isEmpty(user.getId())){
                userService.save(user);
            }else{
                userService.update(user);
            }
            map.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message","用户保存或更新失败！");
        }
        return map;
    }

    //根据id删除一个用户方法
    @GetMapping("/delete")
    public Map<String,Object> delete(String id){
        Map<String,Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success",true);
        } catch (Exception e) {
            map.put("success",false);
            map.put("message","删除用户失败，请稍后再试！");
        }
        return map;
    }

    //根据id查询一个用户方法
    @GetMapping("/findOne")
    public User findOne(String id){
        return userService.findOne(id);
    }

    //模糊搜索
    @GetMapping("/findLike")
    public List<User> findNameOrPhoneCode(String name,String code){
        return userService.findNameOrPhoneCode(name,code);
    }

}
