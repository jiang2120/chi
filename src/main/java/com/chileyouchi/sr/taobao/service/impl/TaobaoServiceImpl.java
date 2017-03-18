package com.chileyouchi.sr.taobao.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.chileyouchi.sr.core.utils.StringUtils;
import com.chileyouchi.sr.modules.weibo.dao.IWeiboDao;
import com.chileyouchi.sr.taobao.dao.TaobaoDao;
import com.chileyouchi.sr.taobao.entity.Taobao;
import com.chileyouchi.sr.taobao.service.TaobaoService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;


@Service("tbService")
public class TaobaoServiceImpl implements TaobaoService {
    @Resource
    private TaobaoDao taobaoDao;
	
	@SuppressWarnings("getItemsList")
	@Override
	public List<Taobao> getItemsList(String key) {
		// TODO Auto-generated method stub
		List<Taobao> list = null;

        if (StringUtils.isNotBlank(key)){
            key = "%"+key.trim()+"%";
        }
    	String url="http://gw.api.taobao.com/router/rest";
    	String appkey="23193348";
    	String secret="21fddd91c15b0da2241e5d3b0e62abbe";
    	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
    	TbkItemGetRequest req = new TbkItemGetRequest();
    	req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
    	req.setQ(key);
    	//req.setCat("16,18");
    	//req.setItemloc("杭州");
    	//req.setSort("tk_rate_des");
    	//req.setIsTmall(false);
    	//req.setIsOverseas(false);
    	//req.setStartPrice(10L);
    	//req.setEndPrice(10L);
    	//req.setStartTkRate(123L);
    	//req.setEndTkRate(123L);
    	//req.setPlatform(1L);
    	//req.setPageNo(123L);
    	//req.setPageSize(20L);
    	try {
			TbkItemGetResponse rsp = client.execute(req);
			
			JSONObject json_rsp = JSONObject.fromObject(rsp.getBody()); 
			//System.out.println(rsp.getBody());
			JSONObject json_rsp_item=json_rsp.getJSONObject("tbk_item_get_response").getJSONObject("results");
			JSONArray list_item=json_rsp_item.getJSONArray("n_tbk_item");
			list = JSONArray.toList(list_item, new Taobao(), new JsonConfig());
            
//			JSONArray list_item_1=(JSONArray) rsp.getResults();
//			list = JSONArray.toList(list_item_1, new Taobao(), new JsonConfig());

            


		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String Test(String key) {
		// TODO Auto-generated method stub
		return key;
	}
	

}
