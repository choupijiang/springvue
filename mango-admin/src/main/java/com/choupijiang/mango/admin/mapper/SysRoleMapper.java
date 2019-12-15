package com.choupijiang.mango.admin.mapper;

import com.choupijiang.mango.admin.model.SysRole;
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
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("select * from  from sys_role\n" +
            "    where name = #{name,jdbcType=VARCHAR}")
    List<SysRole> findByName(String name);
}
