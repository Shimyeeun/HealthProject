package com.mySpring.ex.trainer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.ex.trainer.vo.TrainerVO;

@Repository("trainerDAO")
public class TrainerDAOImpl implements TrainerDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllTrainersList() throws DataAccessException{
		List<TrainerVO> trainersList = sqlSession.selectList("mapper.trainer.selectAllTrainersList");
		System.out.println("DAO");
		return trainersList;
	}

}
