package com.mySpring.ex.main.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.trainer.vo.TrainerVO;

public interface MainDAO {
	public List selectAllTrainersList() throws DataAccessException;
	public void updateMainTrainer(MemberVO memberVO) throws DataAccessException;
	public MemberVO selectMember(String mem_id) throws DataAccessException;
}
