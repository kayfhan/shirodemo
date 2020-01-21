package me.kay.controller;

import me.kay.model.FastjsonTest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-08 13:55
 */
@RestController
public class TestController {

    @GetMapping("/fastjson")
    public FastjsonTest getFastJson() {
        FastjsonTest fastjsonTest = new FastjsonTest();
        fastjsonTest.setId("b0236aa4-926f-4499-ad02-efbd8e932479");
        fastjsonTest.setString("fastjson test");
        fastjsonTest.setIgnore("ignore field");
        fastjsonTest.setDate(new Date());
        return fastjsonTest;
    }

    /**
     * 没有加shiro权限注解
     * @return
     */
    @RequestMapping("/test1")
    public String test1(){
        return "test1";
    }

    /**
     * 添加了shiro权限注解，需要用户有"systemUserAdd"权限
     * @return
     */
    @RequestMapping("/test2")
    @RequiresPermissions("systemUserList")
    public String test2(){
        return "test2";
    }




}
