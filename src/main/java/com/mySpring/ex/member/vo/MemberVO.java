package com.mySpring.ex.member.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
   private String mem_id;
   private String mem_pw;
   private String name;
   private String address;
   private String gender;
   private String birth_date;
   private Date joinDate;
   private int point;
   private String mgr_id;

   public MemberVO() {
      
   }

   public MemberVO(String mem_id, String mem_pw, String mem_name, String mem_address, String mem_gender,
         String mem_birthDate, Date joinDate, String mgr_id) {
      super();
      this.mem_id = mem_id;
      this.mem_pw = mem_pw;
      this.name = mem_name;
      this.address = mem_address;
      this.gender = mem_gender;
      this.birth_date = mem_birthDate;
      this.joinDate = joinDate;
      this.mgr_id = mgr_id;
   }

   public String getMem_id() {
      return mem_id;
   }

   public void setMem_id(String mem_id) {
      this.mem_id = mem_id;
   }

   public String getMem_pw() {
      return mem_pw;
   }

   public void setMem_pw(String mem_pw) {
      this.mem_pw = mem_pw;
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

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getBirth_date() {
      return birth_date;
   }

   public void setBirth_date(String birth_date) {
      this.birth_date = birth_date;
   }

   public Date getJoinDate() {
      return joinDate;
   }

   public void setJoinDate(Date joinDate) {
      this.joinDate = joinDate;
   }

   public int getPoint() {
      return point;
   }

   public void setPoint(int point) {
      this.point = point;
   }

   public String getMgr_id() {
      return mgr_id;
   }

   public void setMgr_id(String mgr_id) {
      this.mgr_id = mgr_id;
   }
}
