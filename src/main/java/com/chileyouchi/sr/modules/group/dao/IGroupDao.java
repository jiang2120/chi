package com.chileyouchi.sr.modules.group.dao;

import com.chileyouchi.sr.core.dao.IBaseDao;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.modules.group.entity.Group;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zchuanzhao on 16/12/23.
 */
public interface IGroupDao extends IBaseDao<Group> {

    /**
     * 获取群组
     * @return
     */
    List<Group> listByPage(@Param("page") Page page, @Param("status") Integer status, @Param("key") String key);

    /**
     * 修改状态
     *
     * @param id
     * @return
     */
    Integer changeStatus(@Param("id") Integer id);

}