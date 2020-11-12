package com.mySpring.ex.trainer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.trainer.dao.TrainerDAO;
import com.mySpring.ex.trainer.vo.TrainerVO;

@Service("trainerService")
@Transactional(propagation = Propagation.REQUIRED)
public class TrainerServiceImpl implements TrainerService {
	@Autowired
	private TrainerDAO trainerDAO;
	
	@Override
	public List<TrainerVO> listTrainers() throws Exception{
		List<TrainerVO> trainersList = trainerDAO.selectAllTrainersList();
		System.out.println("serivce");
		return trainersList;
	}
	@Override
	public int addTrainer(TrainerVO trainer) throws DataAccessException {
		return trainerDAO.insertTrainer(trainer);
	}
	@Override
	public TrainerVO login(TrainerVO trainerVO) throws Exception{
		return trainerDAO.loginById(trainerVO);
	}
	@Override
	   public void updateTrainer(MemberVO memberVO) throws Exception{
	      trainerDAO.updateTrainer(memberVO);
	   }
	
	@Override
	public MemberVO selectMember(String mem_id) throws Exception{
		return trainerDAO.selectMember(mem_id);
	}
}
