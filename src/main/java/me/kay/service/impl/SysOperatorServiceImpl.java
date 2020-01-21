package me.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.kay.entity.sys.SysOperator;
import me.kay.mapper.SysOperatorMapper;
import me.kay.service.SysOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:10
 */
@Service
public class SysOperatorServiceImpl extends ServiceImpl<SysOperatorMapper, SysOperator> implements SysOperatorService {

    @Autowired
    private SysOperatorMapper sysOperatorMapper;

}
