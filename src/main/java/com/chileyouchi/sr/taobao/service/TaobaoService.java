package com.chileyouchi.sr.taobao.service;

import java.util.List;

import com.chileyouchi.sr.taobao.entity.Taobao;

/*
 * 
 * sr
 */
public interface TaobaoService {
	public List<Taobao> getItemsList(String key);
	public String Test(String key);

}
