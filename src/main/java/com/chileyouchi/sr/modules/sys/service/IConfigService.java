package com.chileyouchi.sr.modules.sys.service;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.modules.sys.entity.Config;

import java.util.List;
import java.util.Map;

/**
 * Created by zchuanzhao on 16/9/29.
 */
public interface IConfigService {
    List<Config> allList();

    Map<String,String> getConfigToMap();

    ResponseModel update(Map<String,String> params);
}
