package me.kay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.kay.entity.sys.SysRole;
import me.kay.entity.sys.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:19
 */
@Repository
public interface SysRoleMapper  extends BaseMapper<SysRole> {
    SysUser findByRoleId(String roleId);

    List<String> selectRoleByUserId(String userId);
}
