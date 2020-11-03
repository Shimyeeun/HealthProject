package com.mySpring.ex.challenge.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.challenge.vo.ChallengeVO;
import com.mySpring.ex.challenge.vo.StateVO;

public interface ChallengeDAO {
	public List selectAllChallengesList() throws DataAccessException;
	//public int insertNewArticle(Map articleMap) throws DataAccessException;
	//public void insertNewImage(Map articleMap) throws DataAccessException;
	
	public ChallengeVO selectChallenge(int challengeNO) throws DataAccessException;
	public int updateChallenge(int chal_idx) throws DataAccessException;
	public List selectAllStatesList() throws DataAccessException;
	public void insertChalState(StateVO state) throws DataAccessException;
	public StateVO selectState(String mem_id) throws DataAccessException;
	//public int insertChalState(StateVO state) throws DataAccessException;
	//public void deleteArticle(int articleNO) throws DataAccessException;
	//public List selectImageFileList(int articleNO) throws DataAccessException;
}
