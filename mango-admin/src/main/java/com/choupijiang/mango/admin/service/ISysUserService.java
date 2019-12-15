package com.choupijiang.mango.admin.service;

import com.choupijiang.mango.admin.model.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.choupijiang.mango.admin.model.SysUserRole;
import com.choupijiang.mango.core.page.PageRequest;
import com.choupijiang.mango.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-14
 */
public interface ISysUserService extends CurdService<SysUser> {

    SysUser findByName(String username);

    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 查找用户的角色集合
     * @param
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);


    File createUserExcelFile(PageRequest pageRequest);

}
