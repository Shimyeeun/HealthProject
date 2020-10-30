package com.mySpring.ex.challenge.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.ex.challenge.vo.ChallengeVO;
import com.mySpring.ex.challenge.vo.StateVO;

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
	
	@Override
	public int updateChallenge(int chal_idx) throws DataAccessException {		
		return sqlSession.update("mapper.challenge.updateChallenge", chal_idx);
	}
	
	@Override
	public StateVO updateChalState(int chal_idx) {
		return sqlSession.selectOne("mapper.challenge.updateChalState",chal_idx);
	}
}
