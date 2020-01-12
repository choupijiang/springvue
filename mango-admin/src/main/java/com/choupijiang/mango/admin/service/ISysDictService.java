package com.choupijiang.mango.admin.service;

import com.choupijiang.mango.admin.model.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;
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
public interface ISysDictService extends CurdService<SysDict> {
    List<SysDict> findByLable(String lable);
}
