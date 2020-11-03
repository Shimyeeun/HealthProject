package com.mySpring.ex.board.vo;

 

import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;

import java.sql.Date;

 

import org.springframework.stereotype.Component;

 

@Component("articleVO")

public class ArticleVO {

	private String mem_id;

	private int board_idx;

	private String title;

	private String content;

	private Date upload_date;

	private Date update_date;

	private int cnt;

	private String board_img;

	private String board_thumbImg;

	

	public String getBoard_thumbImg() {

		return board_thumbImg;

	}

	public String getBoard_img() {

		return board_img;

	}

	public void setBoard_img(String board_img) {

		this.board_img = board_img;

	}

	public void setBoard_thumbImg(String board_thumbImg) {

		this.board_thumbImg = board_thumbImg;

	}

	public String getMem_id() {

		return mem_id;

	}

	public void setMem_id(String mem_id) {

		this.mem_id = mem_id;

	}

	public int getBoard_idx() {

		return board_idx;

	}

	public void setBoard_idx(int board_idx) {

		this.board_idx = board_idx;

	}

	public String getTitle() {

		return title;

	}

	public void setTitle(String title) {

		this.title = title;

	}

	public String getContent() {

		return content;

	}

	public void setContent(String content) {

		this.content = content;

	}

	public Date getUpload_date() {

		return upload_date;

	}

	public void setUpload_date(Date upload_date) {

		this.upload_date = upload_date;

	}

	public Date getUpdate_date() {

		return update_date;

	}

	public void setUpdate_date(Date update_date) {

		this.update_date = update_date;

	}

	public int getCnt() {

		return cnt;

	}

	public void setCnt(int cnt) {

		this.cnt = cnt;

	}

	

	

}