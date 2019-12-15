package com.choupijiang.mango.admin.mapper;

import com.choupijiang.mango.admin.model.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-14
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    @Select("select m.* from sys_menu m, sys_user u, sys_user_role ur, sys_role_menu rm\n" +
            "  \twhere u.name = #{userName} and u.id = ur.user_id \n" +
            "  \tand ur.role_id = rm.role_id and rm.menu_id = m.id")
    public List<SysMenu> findByUserName( String userName);

    @Select("  select m.* from sys_menu m, sys_role_menu rm\n" +
            "    where rm.role_id = #{roleId}\n" +
            "    and m.id = rm.menu_id")
    List<SysMenu> findRoleMenus(Long roleId);
}
