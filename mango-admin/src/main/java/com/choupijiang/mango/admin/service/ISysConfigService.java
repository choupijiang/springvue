package com.choupijiang.mango.admin.service;

import com.choupijiang.mango.admin.model.SysConfig;
import com.choupijiang.mango.core.service.CurdService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-14
 */
public interface ISysConfigService extends CurdService<SysConfig> {
    List<SysConfig> findByLable(String lable);
}
