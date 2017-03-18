package com.chileyouchi.sr.modules.mem.service.impl;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.core.interceptor.PageInterceptor;
import com.chileyouchi.sr.modules.group.dao.IGroupFansDao;
import com.chileyouchi.sr.modules.group.entity.GroupFans;
import com.chileyouchi.sr.modules.group.service.IGroupFansService;
import com.chileyouchi.sr.modules.mem.dao.IMemberFansDao;
import com.chileyouchi.sr.modules.mem.entity.Member;
import com.chileyouchi.sr.modules.mem.entity.MemberFans;
import com.chileyouchi.sr.modules.mem.service.IMemberFansService;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by zchuanzhao on 2017/2/21.
 */
@Service("memberFansServiceImpl")
public class MemberFansServiceImpl implements IMemberFansService {
    @Resource
    private IMemberFansDao memberFansDao;

    @Override
    public MemberFans find(Integer whoFollowId, Integer followWhoId) {
        return memberFansDao.find(whoFollowId,followWhoId);
    }

    /**
     * 关注
     */
    @Override
    public ResponseModel save(Integer whoFollowId, Integer followWhoId) {
        if(memberFansDao.find(whoFollowId,followWhoId) == null){
            if(memberFansDao.save(whoFollowId,followWhoId) == 1){
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
     */
    @Override
    public ResponseModel delete(Integer whoFollowId, Integer followWhoId) {
        if(memberFansDao.delete(whoFollowId,followWhoId) > 0){
            return new ResponseModel(1,"取消关注成功");
        }
        return new ResponseModel(-1,"取消关注失败");
    }

    @Override
    public ResponseModel followsList(Page page, Integer whoFollowId) {
        List<MemberFans> list = memberFansDao.followsList(page, whoFollowId);
        ResponseModel model = new ResponseModel(0,page);
        model.setData(list);
        return model;
    }

    @Override
    public ResponseModel fansList(Page page, Integer followWhoId) {
        List<MemberFans> list = memberFansDao.fansList(page, followWhoId);
        ResponseModel model = new ResponseModel(0,page);
        model.setData(list);
        return model;
    }


}
