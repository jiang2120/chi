package com.chileyouchi.sr.modules.weibo.service;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.modules.mem.entity.Member;
import com.chileyouchi.sr.modules.weibo.entity.WeiboComment;


/**
 * Created by zchuanzhao on 2016/10/14.
 */
public interface IWeiboCommentService {

    WeiboComment findById(int id);

    ResponseModel save(Member loginMember,String content,Integer articleId);

    ResponseModel delete(Member loginMember,int id);

    ResponseModel listByWeibo(Page page, int articleId);

    void deleteByWeibo(Integer weiboId);
}
