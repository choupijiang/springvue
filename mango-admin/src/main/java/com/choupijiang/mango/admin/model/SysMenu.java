package com.choupijiang.mango.admin.model;

import java.time.LocalDateTime;
import java.io.Serializable;
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
public class SysMenu extends BaseModel {

    private static final long serialVersionUID = 1L;

    private String name;

    /**
     * ID0
     */
    private Long parentId;

    /**
     * URL,1. /sys/user 2.http(s) 3.iframe:+URL(SQL iframe:/druid/login.html, iframe:)
     */
    private String url;

    /**
     * (sys:user:add,sys:user:edit)
     */
    private String perms;

    /**
     *    0   1   2
     */
    private Integer type;

    private String icon;

    private Integer orderNum;

    /**
     *   -1  0
     */
    private Integer delFlag;

    // 非数据库字段
    @TableField(exist = false)
    private String parentName;
    // 非数据库字段
    @TableField(exist = false)
    private Integer level;
    // 非数据库字段
    @TableField(exist = false)
    private List<SysMenu> children;



}
