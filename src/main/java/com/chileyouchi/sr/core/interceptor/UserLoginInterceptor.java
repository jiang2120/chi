package com.chileyouchi.sr.core.interceptor;

import com.chileyouchi.sr.core.utils.MemberUtil;
import com.chileyouchi.sr.core.utils.SpringContextHolder;
import com.chileyouchi.sr.modules.mem.entity.Member;
import com.chileyouchi.sr.modules.mem.service.IMemberService;
import com.chileyouchi.sr.modules.sys.entity.Config;
import com.chileyouchi.sr.modules.sys.service.IConfigService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

/**
 * Created by zchuanzhao on 2016/11/25.
 */
public class UserLoginInterceptor implements JeesnsInterceptor {

    @Override
    public boolean interceptor(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception{
        try {
            Member loginUser = MemberUtil.getLoginMember(httpServletRequest);
            if (loginUser == null || loginUser.getId() == null) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/member/login");
                return false;
            }else {
                IMemberService memberService = SpringContextHolder.getBean("memberService");
                Member findMember = memberService.findById(loginUser.getId());
                IConfigService configService = SpringContextHolder.getBean("configService");
                Map<String,String> config = configService.getConfigToMap();
                if(1 == Integer.parseInt(config.get("member_email_valid"))){
                    if(findMember.getIsActive() == 0){
                        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/member/active");
                        return false;
                    }
                }
                httpServletRequest.setAttribute("loginUser",findMember);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
