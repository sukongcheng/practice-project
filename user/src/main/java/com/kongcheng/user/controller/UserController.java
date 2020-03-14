package com.kongcheng.user.controller;

import com.kongcheng.user.entity.User;
import com.kongcheng.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("新增用户")
    @PostMapping("/save")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "保存成功";
    }

    @ApiOperation("更新用户信息")
    @PutMapping("/update")
    public String update(@RequestBody User user) {
        userService.update(user);
        return "更新成功";
    }

    @ApiOperation("根据ID查询用户")
    @PostMapping("{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "删除成功";
    }

    @ApiOperation("所有用户列表")
    @PostMapping("list")
    public List<User> list() {
        return userService.list();
    }
}
