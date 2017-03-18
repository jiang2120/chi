package com.chileyouchi.sr.modules.sys.dao;

import com.chileyouchi.sr.core.dao.IBaseDao;
import com.chileyouchi.sr.modules.sys.entity.Config;

import org.apache.ibatis.annotations.Param;

/**
 * 系统配置信息DAO接口
 * Created by zchuanzhao on 2016/11/26.
 */

public interface IConfigDao extends IBaseDao<Config>{

    boolean update(@Param("key") String key,@Param("value") String value);
}