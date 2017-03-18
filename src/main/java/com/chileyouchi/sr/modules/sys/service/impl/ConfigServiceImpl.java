package com.chileyouchi.sr.modules.sys.service.impl;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.modules.sys.dao.IConfigDao;
import com.chileyouchi.sr.modules.sys.entity.Config;
import com.chileyouchi.sr.modules.sys.service.IConfigService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zchuanzhao on 16/9/27.
 */
@Service("configService")
public class ConfigServiceImpl implements IConfigService {
    @Resource
    private IConfigDao configDao;


    @Override
    public List<Config> allList() {
        return configDao.allList();
    }

    @Override
    public Map<String, String> getConfigToMap() {
        List<Config> allList = this.allList();
        Map<String,String> map = new HashMap<>();
        for (Config config : allList) {
            map.put(config.getJkey(),config.getJvalue());
        }
        return map;
    }

    @Override
    public ResponseModel update(Map<String, String> params) {
        for(Map.Entry entry : params.entrySet()){
            configDao.update((String)entry.getKey(),(String)entry.getValue());
        }
        return new ResponseModel(0,"操作成功");
    }


}
