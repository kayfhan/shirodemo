package me.kay.service;

import com.github.pagehelper.Page;
import me.kay.entity.User;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 15:01
 */
public interface UserService {


    Page<User> getUsers();

    User selectById(String id);
}
