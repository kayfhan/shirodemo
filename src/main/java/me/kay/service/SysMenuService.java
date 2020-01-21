package me.kay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.kay.entity.sys.SysMenu;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:10
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> selectMenuTreeByUserId(String userId);
}
