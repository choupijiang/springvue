package com.choupijiang.mango.admin.service.impl;

import com.choupijiang.mango.admin.model.SysLog;
import com.choupijiang.mango.admin.mapper.SysLogMapper;
import com.choupijiang.mango.admin.service.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.choupijiang.mango.core.page.MybatisPageHelper;
import com.choupijiang.mango.core.page.PageRequest;
import com.choupijiang.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-14
 */
@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insert(record);
        }
        return sysLogMapper.updateById(record);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for (SysLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("userName");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysLogMapper);
    }
}
