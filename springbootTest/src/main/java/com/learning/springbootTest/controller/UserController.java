package com.learning.springbootTest.controller;


import com.learning.springbootTest.entity.User;
import com.learning.springbootTest.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户", notes = "根据上传User对象新增用户")
    @PostMapping
    public String save(User user) {
        userService.save(user);
        return "save success";
    }

    @ApiOperation("更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
//            @ApiImplicitParam(name = "username", value = "用户名称", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String")

    })
    @PutMapping("{id}")
    public String update(@RequestBody User user, @PathVariable("id") Long id) {
        if (id != null && userService.selectById(id) == null){
            return "user not exist";
        }
        if (user != null && !user.getId().equals(id)){
            return "unmatched parameters";
        }
        userService.update(user);
        return "update success";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "delete success";
    }

    @GetMapping("{id}")
    public User selectById(@PathVariable("id") Long id){
        return userService.selectById(id);
    }

    @GetMapping
    public List<User> list(){
        return userService.list();
    }

}
