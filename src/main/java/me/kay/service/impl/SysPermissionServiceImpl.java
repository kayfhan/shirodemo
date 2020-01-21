package me.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.kay.entity.sys.SysPermission;
import me.kay.mapper.SysPermissionMapper;
import me.kay.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:10
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    public List<String> selectPermissionByUserId(String userId) {
        return sysPermissionMapper.selectPermissionByUserId(userId);
    }

}
