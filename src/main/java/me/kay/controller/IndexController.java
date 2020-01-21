package me.kay.controller;

import me.kay.entity.sys.SysMenu;
import me.kay.entity.sys.SysPermission;
import me.kay.entity.sys.SysUser;
import me.kay.service.SysMenuService;
import me.kay.service.SysPermissionService;
import me.kay.utils.ResponseHelper;
import me.kay.utils.ResponseModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-08 10:47
 */
@RestController
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 首页，并将登录用户的全名返回前台
     * @return
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    @RequiresPermissions(value = "sys:config", logical = Logical.AND)
    @RequiresRoles("admin")
    public ResponseModel index() {
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        List<SysMenu> sysMenuTree = sysMenuService.selectMenuTreeByUserId(sysUser.getUserId());

        return ResponseHelper.buildResponseModel(sysMenuTree);
    }
}
