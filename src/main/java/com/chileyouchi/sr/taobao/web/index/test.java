package com.chileyouchi.sr.taobao.web.index;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.chileyouchi.sr.taobao.entity.Taobao;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;

public class test {

	public static void main(String[] args) {
		//List<Taobao> list=null;
	   	String url="http://gw.api.taobao.com/router/rest";
    	String appkey="23193348";
    	String secret="21fddd91c15b0da2241e5d3b0e62abbe";
    	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
    	TbkItemGetRequest req = new TbkItemGetRequest();
    	req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
    	req.setQ("t");
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
			//System.out.println(rsp.getBody());
			JSONObject json_rsp = JSONObject.fromObject(rsp.getBody());  
			//System.out.println(json_rsp.getJSONObject("tbk_item_get_response").getJSONObject("results"));
			
			JSONObject json_rsp_item=json_rsp.getJSONObject("tbk_item_get_response").getJSONObject("results");
			JSONArray list_item=json_rsp_item.getJSONArray("n_tbk_item");
			//System.out.println(list_item);
			//List<Taobao> list = (List) JSONArray.toCollection(list_item, Taobao.class);
			List<Taobao> list = JSONArray.toList(list_item, new Taobao(), new JsonConfig());
			
	        Iterator it = list.iterator();  
	        while(it.hasNext()){  
	            Taobao p = (Taobao)it.next();  
	            System.out.println(p.getSmall_images().toString());  
	            Map<String, String> images=p.getSmall_images();
	            for(Map.Entry entry: images.entrySet()){
	            	   System.out.println(entry.getKey()+" = "+entry.getValue());
	            	   ArrayList images_list=(ArrayList) entry.getValue();
	            	   System.out.println(images_list.get(0));
	            	}
	            	 
	            System.out.println(p.getNick());
	        }  
	        
	        
			//list = list_item.toList(list_item, Taobao.class);
//			for (Taobao cast : list) {
//				System.out.println(cast.getNick());
//			}
			
//			System.out.println(json_rsp.getString("tbk_item_get_response"));
//			
//			JSONObject json_rsp_results = JSONObject.fromObject(json_rsp.getString("tbk_item_get_response"));  
//			System.out.println(json_rsp_results.getString("results"));
//			
//			JSONObject json_rsp_results_item = JSONObject.fromObject(json_rsp.getString("results")); 
			
			
//			if (rsp.getBody().lastIndexOf("{") != -1) {
//				JSONArray jsonUserArray = JSONArray.fromObject("["
//						+ rsp.getBody().substring(
//								rsp.getBody().lastIndexOf("{"),
//								rsp.getBody().indexOf("}") + 1) + "]");
//				System.out.println(jsonUserArray.toString());
//				list = jsonUserArray.toList(jsonUserArray, Taobao.class);
//				for (Taobao cast : list) {
//					System.out.println(cast.getNick());
//				}
//			}


		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
