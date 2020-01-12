package com.choupijiang.mango.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.sql.Date;

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
public class SysConfig extends BaseModel {

    private String value;

    private String label;

    private String type;

    private String description;

    private BigDecimal sort;

    private String remarks;

    /**
     * -1  0
     */
    private Integer delFlag;


}
