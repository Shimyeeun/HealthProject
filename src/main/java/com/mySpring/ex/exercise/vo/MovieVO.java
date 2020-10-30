package com.mySpring.ex.exercise.vo;

import org.springframework.stereotype.Component;
 
@Component("movieVO")
public class MovieVO {
	private int movie_idx;
	private String youtube;
	private String category_exr;
	private String title; 
	
	public int getMovie_idx() {
		return movie_idx;
	}
	public void setMovie_idx(int movie_idx) {
		this.movie_idx = movie_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory_exr() {
		return category_exr;
	}
	public void setCategory_exr(String category_exr) {
		this.category_exr = category_exr;
	}
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	
}
