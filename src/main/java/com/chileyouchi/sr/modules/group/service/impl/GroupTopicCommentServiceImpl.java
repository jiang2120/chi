package com.chileyouchi.sr.modules.group.service.impl;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.core.interceptor.PageInterceptor;
import com.chileyouchi.sr.core.utils.ActionUtil;
import com.chileyouchi.sr.core.utils.StringUtils;
import com.chileyouchi.sr.modules.group.dao.IGroupTopicCommentDao;
import com.chileyouchi.sr.modules.group.entity.GroupTopic;
import com.chileyouchi.sr.modules.group.entity.GroupTopicComment;
import com.chileyouchi.sr.modules.group.service.IGroupTopicCommentService;
import com.chileyouchi.sr.modules.group.service.IGroupTopicService;
import com.chileyouchi.sr.modules.mem.entity.Member;
import com.chileyouchi.sr.modules.sys.service.IActionLogService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by zchuanzhao on 2016/12/27.
 */
@Service("groupTopicCommentService")
public class GroupTopicCommentServiceImpl implements IGroupTopicCommentService {
    @Resource
    private IGroupTopicCommentDao groupTopicCommentDao;
    @Resource
    private IGroupTopicService groupTopicService;
    @Resource
    private IActionLogService actionLogService;

    @Override
    public GroupTopicComment findById(int id) {
        return groupTopicCommentDao.findById(id);
    }

    @Override
    public ResponseModel save(Member loginMember, String content, Integer groupTopicId) {
        GroupTopic groupTopic = groupTopicService.findById(groupTopicId,loginMember);
        if(groupTopic == null){
            return new ResponseModel(-1,"帖子不存在");
        }
        if(StringUtils.isEmpty(content)){
            return new ResponseModel(-1,"内容不能为空");
        }
        GroupTopicComment groupTopicComment = new GroupTopicComment();
        groupTopicComment.setMemberId(loginMember.getId());
        groupTopicComment.setGroupTopicId(groupTopicId);
        groupTopicComment.setContent(content);
        int result = groupTopicCommentDao.save(groupTopicComment);
        if(result == 1){
            return new ResponseModel(1,"评论成功");
        }else {
            return new ResponseModel(-1,"评论失败");
        }
    }

    @Override
    public ResponseModel listByGroupTopic(Page page, int groupTopicId) {
        List<GroupTopicComment> list = groupTopicCommentDao.listByGroupTopic(page, groupTopicId);
        ResponseModel model = new ResponseModel(0,page);
        model.setData(list);
        return model;
    }

    @Override
    public void deleteByTopic(int groupTopicId) {
        groupTopicCommentDao.deleteByTopic(groupTopicId);
    }

    @Override
    public ResponseModel delete(Member loginMember,int id){
        GroupTopicComment groupTopicComment = this.findById(id);
        if(groupTopicComment == null){
            return new ResponseModel(-1,"评论不存在");
        }
        int result = groupTopicCommentDao.delete(id);
        if(result == 1){
            actionLogService.save(loginMember.getCurrLoginIp(),loginMember.getId(), ActionUtil.DELETE_GROUP_TOPIC_COMMENT,"ID："+groupTopicComment.getId()+"，内容："+groupTopicComment.getContent());
            return new ResponseModel(1,"删除成功");
        }
        return new ResponseModel(-1,"删除失败");
    }

}
