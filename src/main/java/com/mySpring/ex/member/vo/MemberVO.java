package com.mySpring.ex.member.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_address;
	private String mem_gender;
	private String mem_birthDate;
	private Date joinDate;

	public MemberVO() {
		
	}

	public MemberVO(String mem_id, String mem_pwd, String mem_name, String mem_address, String mem_gender,
			String mem_birthDate) {
		super();
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_name = mem_name;
		this.mem_address = mem_address;
		this.mem_gender = mem_gender;
		this.mem_birthDate = mem_birthDate;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_address() {
		return mem_address;
	}

	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}

	public String getMem_gender() {
		return mem_gender;
	}

	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}

	public String getMem_birthDate() {
		return mem_birthDate;
	}

	public void setMem_birthDate(String mem_birthDate) {
		this.mem_birthDate = mem_birthDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	

	

}
