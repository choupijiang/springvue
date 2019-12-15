package com.choupijiang.mango.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.choupijiang.mango.admin.model.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.choupijiang.mango.admin.model.SysUserRole;
import com.choupijiang.mango.core.service.CurdService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-14
 */
public interface ISysMenuService extends CurdService<SysMenu> {


    /**
     * 查询菜单树,用户ID和用户名为空则查询全部
     * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
     * @param userName
     * @return
     */
    List<SysMenu> findTree(String userName, int menuType);

    /**
     * 根据用户名查找菜单列表
     * @param userName
     * @return
     */
    List<SysMenu> findByUser(String userName);

}
