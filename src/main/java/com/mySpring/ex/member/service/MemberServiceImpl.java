package com.mySpring.ex.member.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.challenge.vo.StateVO;
import com.mySpring.ex.member.dao.MemberDAO;
import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.member.vo.InbodyVO;
import com.mySpring.ex.challenge.vo.*;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		return membersList;
	}

	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.deleteMember(id);
	}
	
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception{
		return memberDAO.loginById(memberVO);
	}

	@Override
	public List<InbodyVO> inbodyList(HashMap hashMap) throws Exception {
		return memberDAO.selectInbodyList(hashMap);
	}

	@Override
	public void insertInbody(InbodyVO inbodyVO) throws DataAccessException {
		memberDAO.insertInbody(inbodyVO);
	}

	@Override
	public String getRecentDate(String mem_id) throws DataAccessException {
		
		return memberDAO.getRecentDate(mem_id);
	}

	@Override
	public List<ChallengeVO> listChallenge(String mem_id) throws Exception {
		 List<ChallengeVO> challengeList =  memberDAO.selectAllChallengeList(mem_id);
	        return challengeList;
	}

}
