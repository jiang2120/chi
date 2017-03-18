package com.chileyouchi.sr.modules.mem.service;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.modules.group.entity.GroupFans;
import com.chileyouchi.sr.modules.mem.entity.Member;
import com.chileyouchi.sr.modules.mem.entity.MemberFans;

import org.apache.ibatis.annotations.Param;


/**
 * Created by zchuanzhao on 17/2/21.
 */
public interface IMemberFansService {

    ResponseModel save(Integer whoFollowId, Integer followWhoId);

    ResponseModel delete(Integer whoFollowId, Integer followWhoId);

    ResponseModel followsList(Page page,Integer whoFollowId);

    ResponseModel fansList(Page page,Integer followWhoId);

    MemberFans find(Integer whoFollowId, Integer followWhoId);
}
