package me.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.kay.entity.sys.SysUser;
import me.kay.mapper.SysUserMapper;
import me.kay.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:10
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Cacheable(cacheNames = "sysusers", key = "'sysuser:'+#userName")
    public SysUser findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
