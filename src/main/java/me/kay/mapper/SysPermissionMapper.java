package me.kay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.kay.entity.sys.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:21
 */
@Repository
public interface SysPermissionMapper  extends BaseMapper<SysPermission> {
    List<String> selectPermissionByUserId(@Param("userId") String userId);
}
