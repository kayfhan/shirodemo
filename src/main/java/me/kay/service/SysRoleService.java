package me.kay.service;

import me.kay.entity.sys.SysUser;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:10
 */
public interface SysRoleService {
    SysUser findByRoleId(String roleId);

    List<String> selectRoleByUserId(String userId);
}
