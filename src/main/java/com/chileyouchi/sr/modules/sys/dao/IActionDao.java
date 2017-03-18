package com.chileyouchi.sr.modules.sys.dao;

import com.chileyouchi.sr.core.dao.IBaseDao;
import com.chileyouchi.sr.modules.sys.entity.Action;

import org.apache.ibatis.annotations.Param;

/**
 * Created by zchuanzhao on 2017/2/14.
 */
public interface IActionDao extends IBaseDao<Action> {
    int isenable(@Param("id") Integer id);
}
