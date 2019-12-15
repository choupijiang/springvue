package com.choupijiang.mango.admin.model;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-12-14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser extends BaseModel {

    private static final long serialVersionUID = 1L;


    private String name;

    private String nickName;

    private String avatar;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    /**
     *   0   1
     */
    private Integer status;

    /**
     * ID
     */
    private Long deptId;

    /**
     *   -1  0
     */
    private Integer delFlag;

    // 非数据库字段
    @TableField(exist = false)
    private String deptName;
    // 非数据库字段
    @TableField(exist = false)
    private String roleNames;
    // 非数据库字段
    @TableField(exist = false)
    private List<SysUserRole> userRoles = new ArrayList<>();



}
