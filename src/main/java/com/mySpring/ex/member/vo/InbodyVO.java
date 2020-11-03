package com.mySpring.ex.member.vo;
import java.sql.Date;
import java.util.*;
public class InbodyVO {
	
	private int body_idx;
	private String mem_id;
	private Date write_date;
	private double height;
	private double weight;
	private double muscle;
	private double body_fat;
	public int getBody_idx() {
		return body_idx;
	}
	public void setBody_idx(int body_idx) {
		this.body_idx = body_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getMuscle() {
		return muscle;
	}
	public void setMuscle(double muscle) {
		this.muscle = muscle;
	}
	public double getBody_fat() {
		return body_fat;
	}
	public void setBody_fat(double body_fat) {
		this.body_fat = body_fat;
	}
	
}
