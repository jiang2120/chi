package com.chileyouchi.sr.core.interceptor;

import com.chileyouchi.sr.core.utils.JeesnsConfig;
import com.chileyouchi.sr.core.utils.MemberUtil;
import com.chileyouchi.sr.core.utils.SpringContextHolder;
import com.chileyouchi.sr.modules.mem.entity.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zchuanzhao on 16/11/25.
 */
public class AdminLoginInterceptor implements JeesnsInterceptor {

    @Override
    public boolean interceptor(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        Member loginAdmin = MemberUtil.getLoginMember(httpServletRequest);
        if (loginAdmin == null || loginAdmin.getIsAdmin() == 0) {
            JeesnsConfig jeesnsConfig = SpringContextHolder.getBean("jeesnsConfig");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/" + jeesnsConfig.getManagePath() + "/login");
            return false;
        }
        return true;
    }
}
