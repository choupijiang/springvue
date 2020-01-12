package com.choupijiang.mango.admin.mapper;

import com.choupijiang.mango.admin.model.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-14
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    @Select("select *\n" +
            "    from sys_user_role\n" +
            "    where user_id = #{userId}")
    List<SysUserRole> findUserRoles(Long userId);
}
