package com.mySpring.ex.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.challenge.dao.ChallengeDAO;
import com.mySpring.ex.challenge.vo.ChallengeVO;
import com.mySpring.ex.challenge.vo.StateVO;


@Service("challengeService")
@Transactional(propagation = Propagation.REQUIRED)
public class ChallengeServiceImpl implements ChallengeService {
	
	@Autowired
	ChallengeDAO challengeDAO;
	
		
	public List<ChallengeVO> listChallenges() throws Exception{
		List<ChallengeVO> challengesList =  challengeDAO.selectAllChallengesList();
        return challengesList;
	}
	
	@Override
	public void updateChallenges(int chal_idx) throws Exception{
		challengeDAO.updateChallenge(chal_idx);
	}
	
	@Override
	public List<StateVO> listStates() throws Exception{
		List<StateVO> statesList=challengeDAO.selectAllStatesList();
		return statesList;
	}
	
	@Override
	public StateVO selectState(String mem_id) throws Exception{
		return challengeDAO.selectState(mem_id);
	}
	
//	@Override
//	public int insertChalState(StateVO state) throws Exception{
//		return challengeDAO.insertChalState(state);
//	}
}
