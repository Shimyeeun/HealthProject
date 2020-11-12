package com.mySpring.ex.member.dao;

import java.util.*;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.challenge.vo.ChallengeVO;
import com.mySpring.ex.member.vo.InbodyVO;

public interface MemberDAO {
	public List selectAllMemberList() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	 public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
	 public List<InbodyVO> selectInbodyList(HashMap hashMap) throws Exception;
	 public void insertInbody(InbodyVO inbodyVO) throws DataAccessException;
	 public String getRecentDate(String mem_id) throws DataAccessException;
	 public List<ChallengeVO> selectAllChallengeList(String mem_id) throws DataAccessException;
}	
