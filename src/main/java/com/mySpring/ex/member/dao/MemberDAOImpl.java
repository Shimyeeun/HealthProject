package com.mySpring.ex.member.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.member.vo.InbodyVO;
import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.challenge.vo.*;


@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}
	
	@Override
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException{
		  MemberVO vo = sqlSession.selectOne("mapper.member.loginById",memberVO);
		return vo;
	}

	@Override
	public List<InbodyVO> selectInbodyList(HashMap hashMap) throws Exception {
		List<InbodyVO> inbodyList = sqlSession.selectList("mapper.inbody.selectInbodyList", hashMap);
		return inbodyList;
	}

	@Override
	public void insertInbody(InbodyVO inbodyVO) throws DataAccessException {
		sqlSession.insert("mapper.inbody.insertInbody", inbodyVO);
	}

	@Override
	public String getRecentDate(String mem_id) throws DataAccessException {
		return sqlSession.selectOne("mapper.inbody.selectRecentDate",mem_id);
	}

	@Override
	public List selectAllChallengeList(String mem_id) throws DataAccessException {
		   List<ChallengeVO> challengeList ;

		   try {

			

			   challengeList  = sqlSession.selectList("mapper.challenge.selectChallengingList", mem_id);

		} catch (Exception e) {

			System.out.println("없습니다.");

			challengeList = null;

	     

	   }

	      return challengeList;

	   }
}

