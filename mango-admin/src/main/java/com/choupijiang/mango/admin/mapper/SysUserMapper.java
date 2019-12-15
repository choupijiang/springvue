package com.choupijiang.mango.admin.mapper;

import com.choupijiang.mango.admin.model.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
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
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select * from sys_user")
    List<SysUser> findAll();

    @Select(" select u.*, (select d.name from sys_dept d where d.id = u.dept_id) deptName from sys_user u\n" +
            "    where u.name = #{name}")
    SysUser findByName(String name);

    List<SysUser> findPageByName( String name);

    List<SysUser> findPageByNameAndEmail(String name, String email);
}
