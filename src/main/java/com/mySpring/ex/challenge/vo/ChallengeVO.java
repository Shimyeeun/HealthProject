package com.mySpring.ex.challenge.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("challengeVO")
public class ChallengeVO {

	private int chal_idx;
	private int total_point;
	private String title;
	private int challenger;
	private Date start_date;
	private Date end_date;
	private int target_point;
	
	public int getChal_idx() {
		return chal_idx;
	}
	public void setChal_idx(int chal_idx) {
		this.chal_idx = chal_idx;
	}
	public int getTotal_point() {
		return total_point;
	}
	public void setTotal_point(int total_point) {
		this.total_point = total_point;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getChallenger() {
		return challenger;
	}
	public void setChallenger(int challenger) {
		this.challenger = challenger;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getTarget_point() {
		return target_point;
	}
	public void setTarget_point(int target_point) {
		this.target_point = target_point;
	}
}
