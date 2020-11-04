package com.mySpring.ex.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.ex.main.DAO.MainDAO;
import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.trainer.vo.TrainerVO;

@Service("mainService")
@Transactional(propagation = Propagation.REQUIRED)
public class MainServiceImpl implements MainService {
	@Autowired
	private MainDAO mainDAO;
	
	@Override
	public List<TrainerVO> listTrainers() throws Exception{
		List<TrainerVO> maintrainersList = mainDAO.selectAllTrainersList();
		System.out.println("∏ﬁ¿Œserivce");
		return maintrainersList;
	}
	
	@Override
	public void updateMainTrainer(MemberVO memberVO) throws Exception{
	   mainDAO.updateMainTrainer(memberVO);
	}
	
	@Override
	public MemberVO selectMember(String mem_id) throws Exception{
		return mainDAO.selectMember(mem_id);
	}
}
