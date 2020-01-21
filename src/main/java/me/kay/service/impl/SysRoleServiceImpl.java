package me.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.kay.entity.sys.SysRole;
import me.kay.entity.sys.SysUser;
import me.kay.mapper.SysRoleMapper;
import me.kay.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:10
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Cacheable(cacheNames = "roles", key = "'sysrole:'+#roleId")
    public SysUser findByRoleId(String roleId) {
        return sysRoleMapper.findByRoleId(roleId);
    }

    public List<String> selectRoleByUserId(String userId) {
        return sysRoleMapper.selectRoleByUserId(userId);
    }
}
