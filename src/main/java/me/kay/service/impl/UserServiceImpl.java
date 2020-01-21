package me.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import me.kay.entity.User;
import me.kay.mapper.UserMapper;
import me.kay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 15:01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Page<User> getUsers() {
        return userMapper.getUsers();
    }

    @Cacheable(cacheNames = "users", key = "'user:'+#id")
    public User selectById(String id) {
        return userMapper.selectById(id);
    }
}
