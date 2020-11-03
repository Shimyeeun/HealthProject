	package com.mySpring.ex.challenge.service;

import java.util.List;
import java.util.Map;

import com.mySpring.ex.challenge.vo.ChallengeVO;
import com.mySpring.ex.challenge.vo.StateVO;

public interface ChallengeService {
	public List<ChallengeVO> listChallenges() throws Exception;
	public void updateChallenges(int chal_idx) throws Exception;
	public List<StateVO> listStates() throws Exception;
	public void insertChalState(StateVO state) throws Exception;
	//public int insertChalState(StateVO state) throws Exception;
	//public int addNewArticle(Map articleMap) throws Exception;
	//public ChallengeVO viewChallenge(int chal_idx) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;
	//public void modArticle(Map articleMap) throws Exception;
	//public void removeArticle(int articleNO) throws Exception;
}
