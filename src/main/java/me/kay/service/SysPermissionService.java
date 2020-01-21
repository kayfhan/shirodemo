package me.kay.service;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:10
 */
public interface SysPermissionService {

    List<String> selectPermissionByUserId(String userId);

}
