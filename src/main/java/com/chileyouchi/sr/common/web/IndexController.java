package com.chileyouchi.sr.common.web;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.entity.Page;
import com.chileyouchi.sr.core.service.IArchiveService;
import com.chileyouchi.sr.core.utils.Const;
import com.chileyouchi.sr.core.utils.Emoji;
import com.chileyouchi.sr.core.utils.ErrorUtil;
import com.chileyouchi.sr.core.utils.MemberUtil;
import com.chileyouchi.sr.core.web.BaseController;
import com.chileyouchi.sr.modules.cms.service.IArticleService;
import com.chileyouchi.sr.modules.group.service.IGroupService;
import com.chileyouchi.sr.modules.group.service.IGroupTopicService;
import com.chileyouchi.sr.modules.mem.entity.Member;
import com.chileyouchi.sr.modules.mem.service.IMemberService;
import com.chileyouchi.sr.modules.sys.entity.ActionLog;
import com.chileyouchi.sr.modules.sys.service.IActionLogService;
import com.chileyouchi.sr.modules.weibo.service.IWeiboService;
import com.chileyouchi.sr.taobao.service.TaobaoService;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zchuanzhao on 2016/11/25.
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController extends BaseController{
    private static final String FTL_PATH = "/index/";
    @Resource
    private IArticleService articleService;
    @Resource
    private IGroupTopicService groupTopicService;
    @Resource
    private IGroupService groupService;
    @Resource
    private IWeiboService weiboService;
    @Resource
    private IMemberService memberService;
    @Resource
    private IArchiveService archiveService;
    @Resource
    private IActionLogService actionLogService;

    @RequestMapping(value="index",method = RequestMethod.GET)
    public String index(@RequestParam(value = "key",required = false,defaultValue = "") String key, Integer cateid,Model model) {
        Page page = new Page(request);
        if(cateid == null){
            cateid = 0;
        }
        Member loginMember = MemberUtil.getLoginMember(request);
        int loginMemberId = loginMember == null ? 0 : loginMember.getId();
        ResponseModel articleModel = articleService.listByPage(page,key,cateid,1,0);
        ResponseModel groupTopicModel = groupTopicService.listByPage(page,key,cateid,1,0);
        ResponseModel groupModel = groupService.listByPage(1,page,key);
        page.setPageSize(50);
        ResponseModel weiboModel = weiboService.listByPage(page,0,loginMemberId,"");
        model.addAttribute("articleModel",articleModel);
        model.addAttribute("groupTopicModel",groupTopicModel);
        model.addAttribute("groupModel",groupModel);
        model.addAttribute("weiboModel",weiboModel);
        String test = weiboService.Test("dfdfdf");
        model.addAttribute("test",test);
        
        return FTL_PATH + "index";
    }

    @RequestMapping(value = "u/{id}",method = RequestMethod.GET)
    public String u(@PathVariable("id") Integer id, Model model){
        Page page = new Page(request);
        Member member = memberService.findById(id);
        if(member == null){
            return ErrorUtil.error(model,-1005, Const.INDEX_ERROR_FTL_PATH);
        }
        model.addAttribute("member",member);
        ResponseModel<ActionLog> list = actionLogService.memberActionLog(page,id);
        model.addAttribute("actionLogModel",list);
        return FTL_PATH + "u";
    }

    @RequestMapping(value = "u/{id}/home/{type}",method = RequestMethod.GET)
    public String home(@PathVariable("id") Integer id, @PathVariable("type") String type, Model model){
        Page page = new Page(request);
        Member member = memberService.findById(id);
        if(member == null){
            return ErrorUtil.error(model,-1005, Const.INDEX_ERROR_FTL_PATH);
        }
        model.addAttribute("member",member);
        Member loginMember = MemberUtil.getLoginMember(request);

        ResponseModel responseModel = memberService.home(loginMember,page,id,type);
        model.addAttribute("model",responseModel);
        model.addAttribute("type",type);
        return FTL_PATH + "home";
    }


    @RequestMapping(value = "newVersion",method = RequestMethod.GET)
    @ResponseBody
    public String newVersion(@RequestParam("callback") String callback){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("LAST_SYSTEM_VERSION",Const.LAST_SYSTEM_VERSION);
        jsonObject.put("LAST_SYSTEM_UPDATE_TIME",Const.LAST_SYSTEM_UPDATE_TIME);
        return callback + "(" + jsonObject.toString() + ")";
    }

    /**
     * 文档、喜欢
     * @param archiveId
     * @return
     */
    @RequestMapping(value="/archive/favor/{archiveId}",method = RequestMethod.GET)
    @ResponseBody
    public Object favor(@PathVariable("archiveId") Integer archiveId){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember == null){
            return new ResponseModel(-1,"请先登录");
        }
        if(archiveId == null) {
            return new ResponseModel(-1, "非法操作");
        }
        return archiveService.favor(loginMember,archiveId);
    }

    /**
     * 获取Emoji数据
     * @return
     */
    @RequestMapping(value="/emoji/emojiJsonData.json",method = RequestMethod.GET)
    @ResponseBody
    public Object emojiJsonData(){
        return Emoji.emojiJson();
    }

    @RequestMapping(value="/404",method = RequestMethod.GET)
    public String jeesns404(){
        return FTL_PATH + "/common/404";
    }

    @RequestMapping(value="/error",method = RequestMethod.GET)
    public String error(){
        return FTL_PATH + "/common/error";
    }

}
