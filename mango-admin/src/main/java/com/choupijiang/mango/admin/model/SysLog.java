package com.choupijiang.mango.admin.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.databind.ser.Serializers;
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
public class SysLog extends BaseModel {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String operation;

    private String method;

    private String params;

    /**
     * ()
     */
    private Long time;

    /**
     * IP
     */
    private String ip;


}
