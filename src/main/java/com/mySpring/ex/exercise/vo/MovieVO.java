package com.mySpring.ex.exercise.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("movieVO")
public class MovieVO {
	private int movie_idx;
	private String url;
	private String category;
	private String title; 
	
	public int getMovie_idx() {
		return movie_idx;
	}
	public void setMovie_idx(int movie_idx) {
		this.movie_idx = movie_idx;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
