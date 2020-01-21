package me.kay.shiro;

import me.kay.entity.sys.SysUser;
import me.kay.service.SysPermissionService;
import me.kay.service.SysRoleService;
import me.kay.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:07
 */
public class UserRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);
    /**
     * 注意此处需要添加@Lazy注解，否则SysUserService缓存注解、事务注解不生效
     */
    @Autowired
    @Lazy
    private SysUserService sysUserService;

    @Autowired
    @Lazy
    private SysRoleService sysRoleService;

    @Autowired
    @Lazy
    private SysPermissionService sysPermissionService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        List<String> sysPermissions = sysPermissionService.selectPermissionByUserId(sysUser.getUserId());
        List<String> sysRoles = sysRoleService.selectRoleByUserId(sysUser.getUserId());
        logger.info("sysPermissions: {}, {}.", sysPermissions, sysRoles);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(sysPermissions);
        info.addRoles(sysRoles);
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser sysUser = sysUserService.findByUserName(token.getUsername());
        if (sysUser == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword().toCharArray(), ByteSource.Util.bytes(sysUser.getSalt()), getName());
    }
}
