package com.choupijiang.mango.admin.service.impl;

import com.choupijiang.mango.admin.model.SysDept;
import com.choupijiang.mango.admin.mapper.SysDeptMapper;
import com.choupijiang.mango.admin.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.choupijiang.mango.core.page.MybatisPageHelper;
import com.choupijiang.mango.core.page.PageRequest;
import com.choupijiang.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-14
 */
@Service
public class SysDeptServiceImpl  implements ISysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public int save(SysDept record) {
        if(record.getId() == null || record.getId() == 0) {
            return sysDeptMapper.insert(record);
        }
        return sysDeptMapper.updateById(record);
    }

    @Override
    public int delete(SysDept record) {
        return sysDeptMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysDept> records) {
        for(SysDept record:records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDept findById(Long id) {
        return sysDeptMapper.selectById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysDeptMapper);
    }

    @Override
    public List<SysDept> findTree() {
        List<SysDept> sysDepts = new ArrayList<>();
        List<SysDept> depts = sysDeptMapper.selectList(null);
        for (SysDept dept : depts) {
            if (dept.getParentId() == null || dept.getParentId() == 0) {
                dept.setLevel(0);
                sysDepts.add(dept);
            }
        }
        findChildren(sysDepts, depts);
        return sysDepts;
    }

    private void findChildren(List<SysDept> sysDepts, List<SysDept> depts) {
        for (SysDept sysDept : sysDepts) {
            List<SysDept> children = new ArrayList<>();
            for (SysDept dept : depts) {
                if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
                    dept.setParentName(dept.getName());
                    dept.setLevel(sysDept.getLevel() + 1);
                    children.add(dept);
                }
            }
            sysDept.setChildren(children);
            findChildren(children, depts);
        }
    }
}
