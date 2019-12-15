package com.choupijiang.mango.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.choupijiang.mango.admin.constant.SysConstants;
import com.choupijiang.mango.admin.mapper.SysMenuMapper;
import com.choupijiang.mango.admin.service.ISysMenuService;
import com.choupijiang.mango.admin.model.SysMenu;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.choupijiang.mango.core.page.MybatisPageHelper;
import com.choupijiang.mango.core.page.PageRequest;
import com.choupijiang.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class SysMenuServiceImpl implements ISysMenuService {


    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public int save(SysMenu record) {
        if(record.getId() == null || record.getId() == 0) {
            return sysMenuMapper.insert(record);
        }
        if(record.getParentId() == null) {
            record.setParentId(0L);
        }
        return sysMenuMapper.updateById(record);
    }

    @Override
    public int delete(SysMenu record) {
        return sysMenuMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysMenu> records) {
        for(SysMenu record:records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysMenu findById(Long id) {
        return sysMenuMapper.selectById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysMenuMapper);
    }

    @Override
    public List<SysMenu> findTree(String userName, int menuType) {
        List<SysMenu> sysMenus = new ArrayList<>();
        List<SysMenu> menus = findByUser(userName);
        for (SysMenu menu : menus) {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);
                if(!exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        }
        sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus, menus, menuType);
        return sysMenus;
    }

    @Override
    public List<SysMenu> findByUser(String userName) {
        if(userName == null || "".equals(userName) || SysConstants.ADMIN.equalsIgnoreCase(userName)) {
            return sysMenuMapper.selectList(null);
        }
        return sysMenuMapper.findByUserName(userName);
    }

    private void findChildren(List<SysMenu> SysMenus, List<SysMenu> menus, int menuType) {
        for (SysMenu SysMenu : SysMenus) {
            List<SysMenu> children = new ArrayList<>();
            for (SysMenu menu : menus) {
                if(menuType == 1 && menu.getType() == 2) {
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue ;
                }
                if (SysMenu.getId() != null && SysMenu.getId().equals(menu.getParentId())) {
                    menu.setParentName(SysMenu.getName());
                    menu.setLevel(SysMenu.getLevel() + 1);
                    if(!exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            SysMenu.setChildren(children);
            children.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children, menus, menuType);
        }
    }

    private boolean exists(List<SysMenu> sysMenus, SysMenu sysMenu) {
        boolean exist = false;
        for(SysMenu menu:sysMenus) {
            if(menu.getId().equals(sysMenu.getId())) {
                exist = true;
            }
        }
        return exist;
    }

}
