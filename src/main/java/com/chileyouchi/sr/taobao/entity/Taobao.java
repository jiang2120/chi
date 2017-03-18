package com.chileyouchi.sr.taobao.entity;

import java.util.HashMap;

import com.chileyouchi.sr.core.entity.BaseEntity;

public class Taobao extends BaseEntity{
	private String item_url;
	private String nick;
	private String num_iid;
	private String pict_url;
	private String provcity;
	private String reserve_price;
	private String seller_id;
	private HashMap small_images;
	private String title;
	private String user_type;
	private String volume;
	private String zk_final_price;
	public Taobao(){
		
	}
	public String getItem_url() {
		return item_url;
	}
	public void setItem_url(String item_url) {
		this.item_url = item_url;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(String num_iid) {
		this.num_iid = num_iid;
	}
	public String getPict_url() {
		return pict_url;
	}
	public void setPict_url(String pict_url) {
		this.pict_url = pict_url;
	}
	public String getProvcity() {
		return provcity;
	}
	public void setProvcity(String provcity) {
		this.provcity = provcity;
	}
	public String getReserve_price() {
		return reserve_price;
	}
	public void setReserve_price(String reserve_price) {
		this.reserve_price = reserve_price;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
//	public String getSmall_images() {
//		return small_images;
//	}
//	public void setSmall_images(String small_images) {
//		this.small_images = small_images;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public HashMap getSmall_images() {
		return small_images;
	}
	public void setSmall_images(HashMap small_images) {
		this.small_images = small_images;
	}
	public String getZk_final_price() {
		return zk_final_price;
	}
	public void setZk_final_price(String zk_final_price) {
		this.zk_final_price = zk_final_price;
	}
	
	

}
