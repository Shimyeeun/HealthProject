package com.mySpring.ex.member.dao;

import java.util.*;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.member.vo.InbodyVO;

public interface MemberDAO {
	public List selectAllMemberList() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	 public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
	 public List<InbodyVO> selectInbodyList(HashMap hashMap) throws Exception;
}	
