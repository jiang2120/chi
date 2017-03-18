package com.chileyouchi.sr.modules.weibo.dao;

import com.chileyouchi.sr.core.dao.IBaseDao;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.modules.weibo.entity.Weibo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zchuanzhao on 2016/11/25.
 */
public interface IWeiboDao extends IBaseDao<Weibo> {

    /**
     * 列表
     * @param memberId 查询该会员微博列表
     * @param loginMemberId 当前登录的会员ID，用来判断是否已点赞
     * @return
     */
    List<Weibo> listByPage(@Param("page") Page page, @Param("memberId") int memberId, @Param("loginMemberId") int loginMemberId, @Param("key") String key);

    int save(Weibo weibo);

    int delete(int id);

    List<Weibo> hotList(@Param("loginMemberId") int loginMemberId);

    int favor(@Param("id") Integer id,@Param("num") Integer num);

    /**
     * 查询微博明细
     * @param id
     * @param loginMemberId 当前登录的会员ID，用来判断是否已点赞
     * @return
     */
    Weibo findById(@Param("id") Integer id,@Param("loginMemberId") Integer loginMemberId);
    String Test(String key);
}
