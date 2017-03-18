package com.chileyouchi.sr.taobao.web.index;

import java.util.Iterator;
import java.util.List;

import com.chileyouchi.sr.core.dto.ResponseModel;
import com.chileyouchi.sr.core.web.BaseController;
import com.chileyouchi.sr.modules.sys.entity.ActionLog;
import com.chileyouchi.sr.modules.weibo.service.IWeiboService;
import com.chileyouchi.sr.taobao.dao.TaobaoDao;
import com.chileyouchi.sr.taobao.entity.Taobao;
import com.chileyouchi.sr.taobao.service.TaobaoService;
import com.taobao.api.ApiException;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zchuanzhao on 2016/11/25.
 */
@Controller("taobaoController")
@RequestMapping("/")
public class taobaoController extends BaseController{
    private static final String FTL_PATH = "/taobao/";

    @Resource
    private TaobaoService taobaoService;


	@RequestMapping(value="taobao",method = RequestMethod.GET)
    public String taobaoIndex(Model model) throws ApiException {
//    	String url="http://gw.api.taobao.com/router/rest";
//    	String appkey="23193348";
//    	String secret="21fddd91c15b0da2241e5d3b0e62abbe";
//    	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//    	TbkItemGetRequest req = new TbkItemGetRequest();
//    	req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
//    	req.setQ(word);
//    	//req.setCat("16,18");
//    	//req.setItemloc("杭州");
//    	//req.setSort("tk_rate_des");
//    	//req.setIsTmall(false);
//    	//req.setIsOverseas(false);
//    	//req.setStartPrice(10L);
//    	//req.setEndPrice(10L);
//    	//req.setStartTkRate(123L);
//    	//req.setEndTkRate(123L);
//    	//req.setPlatform(1L);
//    	//req.setPageNo(123L);
//    	//req.setPageSize(20L);
//    	TbkItemGetResponse rsp = client.execute(req);
//    	System.out.println(rsp.getBody());
//        //request.setAttribute("article", rsp.getBody());
//        model.addAttribute("itemsModel",rsp.getBody());
        //List<Taobao> getItemsList = taobaoService.getItemsList("t");
		//String test = taobaoService.Test("dfdfdf");
		//request.setAttribute("test", test);
		//String getItemsList = "test";
        List<Taobao> getItemsList = taobaoService.getItemsList("t");
        //System.out.println(getItemsList);
//        while(getItemsList.hasNext()){  
//           // Taobao p = (Taobao)it.next();  
//            System.out.println(p.getSmall_images().toString());  
//            System.out.println(p.getNick());
//            System.out.println(p.getNum_iid());
//            System.out.println(p.getReserve_price());
//        }  
        //System.out.println(getItemsList.toString());
		model.addAttribute("getItemsList",getItemsList);
        return FTL_PATH + "index";
    }


}
