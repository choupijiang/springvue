package com.choupijiang.mango.admin.service;

import com.choupijiang.mango.admin.model.SysMenu;
import com.choupijiang.mango.admin.model.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.choupijiang.mango.admin.model.SysRoleMenu;
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
public interface ISysRoleService extends CurdService<SysRole> {
    /**
     * 查询全部
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询角色菜单集合
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单
     * @param records
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);

}
