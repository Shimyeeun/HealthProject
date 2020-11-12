package com.mySpring.ex.member.service;

import java.util.*;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.board.domain.CommentVO;
import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.member.vo.InbodyVO;
import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.challenge.vo.*;


public interface MemberService {
	 public List listMembers() throws DataAccessException;
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws Exception;
	 public List<InbodyVO> inbodyList(HashMap hashMap) throws Exception;
	 public void insertInbody(InbodyVO inbodyVO) throws DataAccessException;
	 public String getRecentDate(String mem_id) throws DataAccessException;
	 public List<ChallengeVO> listChallenge(String mem_id) throws Exception;
}
