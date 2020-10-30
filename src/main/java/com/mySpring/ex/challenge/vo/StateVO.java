package com.mySpring.ex.challenge.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("stateVO")
public class StateVO {
	private int state_idx;
	private String mem_id;
	private int chal_idx;
	
	public int getState_idx() {
		return state_idx;
	}
	public void setState_idx(int state_idx) {
		this.state_idx = state_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getChal_idx() {
		return chal_idx;
	}
	public void setChal_idx(int chal_idx) {
		this.chal_idx = chal_idx;
	}
	
	
}
