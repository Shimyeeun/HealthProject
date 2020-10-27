package com.mySpring.ex.challenge.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.ex.challenge.vo.ChallengeVO;

@Repository("challengeDAO")
public class ChallengeDAOImpl implements ChallengeDAO {
	@Autowired
	private SqlSession sqlSession;	

	@Override
	public List selectAllChallengesList() throws DataAccessException {
		List<ChallengeVO> challengesList  = sqlSession.selectList("mapper.challenge.selectAllChallengesList");
		//System.out.println("id: " + articlesList.get(0).getMem_id());
		System.out.println("chal_idx: " + challengesList.get(0).getChal_idx());
		return challengesList;
	}
	
	@Override
	public ChallengeVO selectChallenge(int chal_idx) throws DataAccessException {
		return sqlSession.selectOne("mapper.challenge.selectChallenge",chal_idx);
	}
}
