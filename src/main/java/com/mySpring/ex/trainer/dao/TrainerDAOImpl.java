package com.mySpring.ex.trainer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.ex.member.vo.MemberVO;
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
	@Override
	public int insertTrainer(TrainerVO trainerVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.trainer.insertTrainer", trainerVO);
		return result;
	}
	@Override
	public TrainerVO loginById(TrainerVO trainerVO) throws DataAccessException{
		  TrainerVO vo = sqlSession.selectOne("mapper.trainer.loginById",trainerVO);
		return vo;
	}
	@Override
	   public void updateTrainer(MemberVO memberVO) throws DataAccessException{
	      sqlSession.update("mapper.trainer.updateTrainer",memberVO);
	   }
	@Override
	public MemberVO selectMember(String mem_id) throws DataAccessException{
		return sqlSession.selectOne("mapper.member.selectMemInfo",mem_id);
	}
}
