package me.kay;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;

public class shiroTest {

    @Test
    public void testPed(){
        Md5Hash md5 = new Md5Hash("123","833d7bef-73e5-45fe-8a47-15db8078f525",1);
        System.out.println(md5.toHex());
        for (int i = 0; i < 2; i++) {
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid.toString());
        }
    }

    @Test
    public void testHelloworld() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  Factory<org.apache.shiro.mgt.SecurityManager> factory =
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("kay", "123");
        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }

    @Test
    public void testAllSuccessfulStrategyWithSuccess() {
        login("classpath:shiro.ini");
        Subject subject = SecurityUtils.getSubject();
        //得到一个身份集合，其包含了Realm验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(2, principalCollection.asList().size());
    }

    @Test
    public void testHasRole() {
        Subject subject = subject("classpath:shiro.ini", "kay", "123");
        //判断拥有角色：role1
//        Assert.assertTrue(subject().hasRole("role1"));
//        //判断拥有角色：role1 and role2
//        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject.hasRoles(Arrays.asList("admin", "develop"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertTrue(subject.isPermitted("user:create"));
        //判断拥有权限：user:update and user:delete
        Assert.assertTrue(subject.isPermittedAll("user:update", "user:delete"));
        //判断没有权限：user:view
        Assert.assertFalse(subject.isPermitted("user:view"));
    }

    private void login(String configFile) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("kay", "123");
        subject.login(token);
    }

    private Subject subject(String configFile, String name, String pwd) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
        subject.login(token);
        return subject;
    }
}
