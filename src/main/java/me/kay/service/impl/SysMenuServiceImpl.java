package me.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.kay.entity.sys.SysMenu;
import me.kay.mapper.SysMenuMapper;
import me.kay.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:10
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    public List<SysMenu> selectMenuTreeByUserId(String userId) {
        return sysMenuMapper.selectMenuTreeByUserId(userId);
    }
}
