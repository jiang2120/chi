package com.chileyouchi.sr.modules.cms.service;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.modules.cms.entity.ArticleCate;

import java.util.List;


/**
 * Created by zchuanzhao on 16/9/29.
 */
public interface IArticleCateService {

    ArticleCate findById(int id);

    int save(ArticleCate articleCate);

    int update(ArticleCate articleCate);

    ResponseModel delete(int id);

    /**
     * 获取栏目
     * @return
     */
    List<ArticleCate> list();

    /**
     * 通过父类ID获取子类列表
     * @param fid
     * @return
     */
    List<ArticleCate> findListByFid(int fid);
}
