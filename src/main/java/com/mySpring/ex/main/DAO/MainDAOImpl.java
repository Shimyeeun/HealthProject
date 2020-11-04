package com.mySpring.ex.main.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.trainer.vo.TrainerVO;

@Repository("mainDAO")
public class MainDAOImpl implements MainDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllTrainersList() throws DataAccessException{
		List<TrainerVO> maintrainersList = sqlSession.selectList("mapper.trainer.selectAllTrainersList");
		System.out.println("∏ﬁ¿ŒDAO");
		return maintrainersList;
	}
	
	@Override
	public void updateMainTrainer(MemberVO memberVO) throws DataAccessException{
	   
	   sqlSession.update("mapper.trainer.updateTrainer",memberVO);
	}
	
	@Override
	public MemberVO selectMember(String mem_id) throws DataAccessException{
		return sqlSession.selectOne("mapper.member.selectMemInfo", mem_id);
	}
}
