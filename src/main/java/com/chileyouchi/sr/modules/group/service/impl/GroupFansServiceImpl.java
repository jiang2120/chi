package com.chileyouchi.sr.modules.group.service.impl;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.core.interceptor.PageInterceptor;
import com.chileyouchi.sr.core.utils.Const;
import com.chileyouchi.sr.core.utils.StringUtils;
import com.chileyouchi.sr.modules.group.dao.IGroupDao;
import com.chileyouchi.sr.modules.group.dao.IGroupFansDao;
import com.chileyouchi.sr.modules.group.entity.Group;
import com.chileyouchi.sr.modules.group.entity.GroupFans;
import com.chileyouchi.sr.modules.group.service.IGroupFansService;
import com.chileyouchi.sr.modules.group.service.IGroupService;
import com.chileyouchi.sr.modules.mem.entity.Member;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by zchuanzhao on 2016/12/26.
 */
@Service("groupFansService")
public class GroupFansServiceImpl implements IGroupFansService {
    @Resource
    private IGroupFansDao groupFansDao;

    @Override
    public ResponseModel listByPage(Page page, Integer groupId) {
        List<GroupFans> list = groupFansDao.listByPage(page, groupId);
        ResponseModel model = new ResponseModel(0,page);
        model.setData(list);
        return model;
    }

    @Override
    public GroupFans findByMemberAndGroup(@Param("groupId") Integer groupId, @Param("memberId") Integer memberId) {
        return groupFansDao.findByMemberAndGroup(groupId,memberId);
    }

    /**
     * 关注
     * @param loginMember
     * @param groupId
     * @return
     */
    @Override
    public ResponseModel save(Member loginMember,Integer groupId) {
        if(groupFansDao.findByMemberAndGroup(groupId,loginMember.getId()) == null){
            if(groupFansDao.save(groupId,loginMember.getId()) == 1){
                return new ResponseModel(1,"关注成功");
            }
        }else {
            //已经关注了
            return new ResponseModel(0,"关注成功");
        }
        return new ResponseModel(-1,"关注失败");
    }

    /**
     * 取消关注
     * @param loginMember
     * @param groupId
     * @return
     */
    @Override
    public ResponseModel delete(Member loginMember,Integer groupId) {
        if(groupFansDao.delete(groupId,loginMember.getId()) > 0){
            return new ResponseModel(1,"取消关注成功");
        }
        return new ResponseModel(-1,"取消关注失败");
    }


    @Override
    public ResponseModel listByMember(Page page, Integer memberId) {
        List<Group> list = groupFansDao.listByMember(page, memberId);
        ResponseModel model = new ResponseModel(0,page);
        model.setData(list);
        return model;
    }

}
