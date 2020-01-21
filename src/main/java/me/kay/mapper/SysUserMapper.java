package me.kay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.kay.entity.sys.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:19
 */
@Repository
public interface SysUserMapper  extends BaseMapper<SysUser> {
    SysUser findByUserName(String userName);
}
