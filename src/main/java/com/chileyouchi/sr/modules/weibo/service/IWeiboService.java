package com.chileyouchi.sr.modules.weibo.service;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.modules.mem.entity.Member;
import com.chileyouchi.sr.modules.weibo.entity.Weibo;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * Created by zchuanzhao on 2016/11/25.
 */
public interface IWeiboService {

    Weibo findById(int id,int memberId);

    ResponseModel save(Member loginMember, String content);

    ResponseModel<Weibo> listByPage(Page page, int memberId,int loginMemberId,String key);

    ResponseModel delete(Member loginMember, int id);

    ResponseModel userDelete(Member loginMember, int id);

    List<Weibo> hotList(int loginMemberId);

    ResponseModel favor(Member loginMember, int weiboId);
    
    String Test(String key);
}
