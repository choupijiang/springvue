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
import org.apache.commons.collections.functors.FalsePredicate;

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
public class SysDept extends BaseModel {



    private String name;

    /**
     * ID0
     */
    private Long parentId;

    private Integer orderNum;


    /**
     *   -1  0
     */
    private Integer delFlag;

    // 非数据库字段
    @TableField(exist = false)
    private List<SysDept> children;
    // 非数据库字段
    @TableField(exist = false)
    private String parentName;
    // 非数据库字段
    @TableField(exist = false)
    private Integer level;


}
