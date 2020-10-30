package com.mySpring.ex.trainer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.trainer.vo.TrainerVO;

public interface TrainerDAO {
	public List selectAllTrainersList() throws DataAccessException;
	 public int insertTrainer(TrainerVO trainerVO) throws DataAccessException ;
	 public TrainerVO loginById(TrainerVO trainerVO) throws DataAccessException;
}
