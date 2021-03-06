package com.chileyouchi.sr.modules.group.service;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.modules.group.entity.GroupFans;
import com.chileyouchi.sr.modules.mem.entity.Member;

import org.apache.ibatis.annotations.Param;


/**
 * Created by zchuanzhao on 16/12/26.
 */
public interface IGroupFansService {

    ResponseModel save(Member loginMember, Integer groupId);

    ResponseModel delete(Member loginMember, Integer groupId);

    ResponseModel listByPage(Page page, Integer groupId);

    GroupFans findByMemberAndGroup(@Param("groupId") Integer groupId, @Param("memberId") Integer memberId);

    /**
     * 获取用户关注的群组列表
     * @param page
     * @param memberId
     * @return
     */
    ResponseModel listByMember(Page page, Integer memberId);
}
