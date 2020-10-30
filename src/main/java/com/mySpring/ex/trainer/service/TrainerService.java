package com.mySpring.ex.trainer.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.trainer.vo.TrainerVO;

public interface TrainerService {
	public List<TrainerVO> listTrainers() throws Exception;
	public int addTrainer(TrainerVO trainerVO) throws DataAccessException;
	public TrainerVO login(TrainerVO trainerVO) throws Exception;
}
