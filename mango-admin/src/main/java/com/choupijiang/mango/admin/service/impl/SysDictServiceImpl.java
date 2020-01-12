package com.choupijiang.mango.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.choupijiang.mango.admin.mapper.SysDictMapper;
import com.choupijiang.mango.admin.service.ISysDictService;
import com.choupijiang.mango.admin.model.SysDict;
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
public class SysDictServiceImpl implements ISysDictService {
    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public int save(SysDict record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDictMapper.insert(record);
        }
        return sysDictMapper.updateById(record);
    }

    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        for (SysDict record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
    }

    @Override
    public List<SysDict> findByLable(String lable) {
        SysDict sysDict = new SysDict().setLabel(lable);
        QueryWrapper queryWrapper = new QueryWrapper(sysDict);
        return sysDictMapper.selectList(queryWrapper);
    }
}
