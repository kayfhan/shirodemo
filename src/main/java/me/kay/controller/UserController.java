package me.kay.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.kay.entity.User;
import me.kay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 14:59
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public PageInfo<User> lists(@RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userService.getUsers());
        return pageInfo;
    }

    @GetMapping("/user/{id}")
    public User selectUserById(@PathVariable("id") String id){
        return userService.selectById(id);
    }

}
