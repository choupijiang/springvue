package com.choupijiang.mango.admin.model;

import java.time.LocalDateTime;
import java.io.Serializable;

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
public class SysLoginLog extends BaseModel {

    private static final long serialVersionUID = 1L;

    private String userName;

    /**
     * online:login:onlineloginlogout:
     */
    private String status;

    /**
     * IP
     */
    private String ip;


}
