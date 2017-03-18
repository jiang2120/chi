package com.chileyouchi.sr.modules.group.service;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.modules.cms.entity.ArticleComment;
import com.chileyouchi.sr.modules.group.entity.GroupTopicComment;
import com.chileyouchi.sr.modules.mem.entity.Member;

import org.apache.ibatis.annotations.Param;


/**
 * Created by zchuanzhao on 2016/12/27.
 */
public interface IGroupTopicCommentService {

    GroupTopicComment findById(int id);

    ResponseModel save(Member loginMember, String content, Integer groupTopicId);

    ResponseModel delete(Member loginMember,int id);

    ResponseModel listByGroupTopic(Page page, int groupTopicId);

    void deleteByTopic(int groupTopicId);
}
