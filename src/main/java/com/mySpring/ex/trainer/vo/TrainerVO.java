package com.mySpring.ex.trainer.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("trainerVO")
public class TrainerVO {
	private String mgr_id;
	private String mgr_pw;
	private String name;
	private String address;
	private String trainer_img;
	private String gender;
	private String intro;
	private Date join_date;
	private String trainer_thumbimg;
	
	public String getMgr_id() {
		return mgr_id;
	}
	public void setMgr_id(String mgr_id) {
		this.mgr_id = mgr_id;
	}
	public String getMgr_pw() {
		return mgr_pw;
	}
	public void setMgr_pw(String mgr_pw) {
		this.mgr_pw = mgr_pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String gettrainer_img() {
		return trainer_img;
	}
	public void settrainer_img(String trainer_img) {
		this.trainer_img = trainer_img;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getTrainer_thumbimg() {
		return trainer_thumbimg;
	}
	public void setTrainer_thumbimg(String trainer_thumbimg) {
		this.trainer_thumbimg = trainer_thumbimg;
	}
	
	
}

