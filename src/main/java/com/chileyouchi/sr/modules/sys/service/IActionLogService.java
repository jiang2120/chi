package com.chileyouchi.sr.modules.sys.service;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.modules.sys.entity.ActionLog;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zchuanzhao on 2017/2/14.
 */
public interface IActionLogService {

    ResponseModel<ActionLog> listByPage(Page page,Integer memberId);

    ResponseModel<ActionLog> memberActionLog(Page page,Integer memberId);

    ActionLog findById(Integer id);

    void save(String actionIp,Integer memberId, Integer actionId);

    void save(String actionIp,Integer memberId, Integer actionId,String remark);

    void save(String actionIp,Integer memberId, Integer actionId,String remark, Integer type, Integer foreignId);

}
