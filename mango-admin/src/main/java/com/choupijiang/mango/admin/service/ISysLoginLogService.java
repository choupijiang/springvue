package com.choupijiang.mango.admin.service;

import com.choupijiang.mango.admin.mapper.SysLoginLogMapper;
import com.choupijiang.mango.admin.model.SysLoginLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.choupijiang.mango.core.page.MybatisPageHelper;
import com.choupijiang.mango.core.page.PageRequest;
import com.choupijiang.mango.core.page.PageResult;
import com.choupijiang.mango.core.service.CurdService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-14
 */
public interface ISysLoginLogService extends CurdService<SysLoginLog> {

}
