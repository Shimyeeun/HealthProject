package com.mySpring.ex.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.trainer.vo.TrainerVO;



public interface MainService {	
	public List<TrainerVO> listTrainers() throws Exception;
	public void updateMainTrainer(MemberVO memberVO) throws Exception;
	public MemberVO selectMember(String mem_id) throws Exception;
}
