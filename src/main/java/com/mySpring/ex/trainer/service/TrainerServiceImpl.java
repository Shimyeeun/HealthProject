package com.mySpring.ex.trainer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.ex.trainer.dao.TrainerDAO;
import com.mySpring.ex.trainer.vo.TrainerVO;

@Service("trainerService")
@Transactional(propagation = Propagation.REQUIRED)
public class TrainerServiceImpl implements TrainerService {
	@Autowired
	TrainerDAO trainerDAO;
	
	public List<TrainerVO> listTrainers() throws Exception{
		List<TrainerVO> trainersList = trainerDAO.selectAllTrainersList();
		System.out.println("serivce");
		return trainersList;
	}
	
}
