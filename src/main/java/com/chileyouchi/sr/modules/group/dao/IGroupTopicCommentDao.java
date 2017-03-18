package com.chileyouchi.sr.modules.group.dao;

import com.chileyouchi.sr.core.dao.IBaseDao;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.modules.group.entity.GroupTopicComment;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zchuanzhao on 16/12/27.
 */
public interface IGroupTopicCommentDao extends IBaseDao<GroupTopicComment> {

    List<GroupTopicComment> listByGroupTopic(@Param("page") Page page, @Param("groupTopicId") Integer groupTopicId);

    int deleteByTopic(@Param("groupTopicId") Integer groupTopicId);
}