package com.chileyouchi.sr.modules.sys.service;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.modules.sys.entity.Action;

import java.util.List;

/**
 * Created by zchuanzhao on 2017/2/14.
 */
public interface IActionService {

    List<Action> list();

    Action findById(Integer id);

    ResponseModel update(Action action);

    ResponseModel isenable(Integer id);

    boolean canuse(Integer id);
}
