package me.kay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import me.kay.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 15:02
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    Page<User> getUsers();
}
