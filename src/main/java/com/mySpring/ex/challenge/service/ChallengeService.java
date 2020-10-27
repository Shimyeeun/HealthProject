package com.mySpring.ex.challenge.service;

import java.util.List;
import java.util.Map;

import com.mySpring.ex.challenge.vo.ChallengeVO;

public interface ChallengeService {
	public List<ChallengeVO> listChallenges() throws Exception;
	public ChallengeVO updateChallenges(int chal_idx) throws Exception;
	//public int addNewArticle(Map articleMap) throws Exception;
	//public ChallengeVO viewChallenge(int chal_idx) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;
	//public void modArticle(Map articleMap) throws Exception;
	//public void removeArticle(int articleNO) throws Exception;
}
