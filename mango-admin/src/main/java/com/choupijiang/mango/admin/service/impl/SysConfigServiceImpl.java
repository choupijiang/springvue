package com.choupijiang.mango.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.choupijiang.mango.admin.mapper.SysConfigMapper;
import com.choupijiang.mango.admin.model.SysConfig;
import com.choupijiang.mango.admin.service.ISysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.choupijiang.mango.core.page.MybatisPageHelper;
import com.choupijiang.mango.core.page.PageRequest;
import com.choupijiang.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-14
 */
@Service
public class SysConfigServiceImpl  implements ISysConfigService {


    @Autowired
    private SysConfigMapper sysConfigMapper;


    @Override
    public int save(SysConfig record) {
        if(record.getId() == null || record.getId() == 0) {
            return sysConfigMapper.insert(record);
        }
        return sysConfigMapper.updateById(record);
    }

    @Override
    public int delete(SysConfig record) {
        return sysConfigMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysConfig> records) {
        for(SysConfig record:records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysConfig findById(Long id) {
        return sysConfigMapper.selectById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        if(label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysConfigMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysConfigMapper);
    }


    public List<SysConfig> findByLable(String lable) {
        SysConfig sysConfig = new SysConfig().setLabel(lable);
        QueryWrapper queryWrapper = new QueryWrapper(sysConfig);
        return sysConfigMapper.selectList(queryWrapper);
    }

}
