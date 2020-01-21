package me.kay.service;

import me.kay.entity.sys.SysUser;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:10
 */
public interface SysUserService {


    SysUser findByUserName(String userName);
}
