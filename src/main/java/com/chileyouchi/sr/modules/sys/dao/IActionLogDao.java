package com.chileyouchi.sr.modules.sys.dao;

import com.chileyouchi.sr.core.dao.IBaseDao;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.modules.sys.entity.ActionLog;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zchuanzhao on 2017/2/14.
 */
public interface IActionLogDao extends IBaseDao<ActionLog> {

    List<ActionLog> listByPage(@Param("page") Page page, @Param("memberId") Integer memberId);

    List<ActionLog> memberActionLog(@Param("page") Page page, @Param("memberId") Integer memberId);
}
