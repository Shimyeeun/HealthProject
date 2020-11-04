package com.mySpring.ex.member.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mySpring.ex.board.domain.CommentVO;
import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.member.service.MemberService;
import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.member.vo.InbodyVO;
import com.mySpring.ex.challenge.vo.*;


@Controller("memberController")  //BEAN�쑝濡� �삱�젮以�
//@EnableAspectJAutoProxy
public class MemberControllerImpl  implements MemberController {
	@Autowired  //MemberService자동주입
	private MemberService memberService;
	@Autowired   //MemberService 자동주입 
	MemberVO memberVO ;
	
	
	
	@Override
	@RequestMapping(value="/member/mypage.do" ,method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String viewName = (String)request.getAttribute("viewName");
		HttpSession session = request.getSession();
		
		MemberVO memberVO = (MemberVO) session.getAttribute("member");		
		
		List<ChallengeVO> challList = memberService.listChallenge(memberVO.getMem_id());
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("challList", challList);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/addMember.do" ,method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/loginForm.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/removeMember.do" ,method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/mypage.do");
		return mav;
	}
	/*
	@RequestMapping(value = { "/member/loginForm.do", "/member/memberForm.do" }, method =  RequestMethod.GET)
	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	*/
	
	
	   @Override
	   @RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	   public ModelAndView login(@ModelAttribute("member") MemberVO member,
	                          RedirectAttributes rAttr,
	                             HttpServletRequest request, HttpServletResponse response) throws Exception {

	      System.out.println("mem_id: " + request.getParameter("mem_id"));
	      System.out.println("mem_pwd: " + request.getParameter("mem_pwd"));
	      
	      MemberVO memverVO2 = new MemberVO();
	      
	      memverVO2.setMem_id(request.getParameter("mem_id"));
	      memverVO2.setMem_pw(request.getParameter("mem_pwd"));
	      
	      ModelAndView mav = new ModelAndView();
	   memberVO = memberService.login(memverVO2);
	   if(memberVO != null) {  //memberVO 정보를 db와 비교해서 있으면
	       HttpSession session = request.getSession();
	       //session 객체의 setAtrribute메서드를 사용해 member에 속성값으로 MemberVO를 할당
	       session.setAttribute("member", memberVO);
	       //session 객체의 setAttribute메서드를 사용해 isLogOn은 true를 할당
	       session.setAttribute("isLogOn", true);  //login  셿猷 
	       //mav.setViewName("redirect:/member/listMembers.do");
	       //session 객체의 getAttribute메서드를 사용해 속성명이 action인 속성의 값을 String 타입으로 변환 
	       //String 타입으로 변환한것을 action 변수에 담아 
	       String action = (String)session.getAttribute("action");
	       //sesion 객체의 removeAttribute메서드를 사용해 action의 속성을 삭제 
	    
	       session.removeAttribute("action");
	       if(action!= null) {
	          mav.setViewName("redirect:"+action);
	       }else {
	          mav.setViewName("redirect:/main.do");   
	       }

	   }else {  //memberVO 정보를 db와 비교해서 없으면
	      rAttr.addAttribute("result","loginFailed");
	      mav.setViewName("redirect:/member/loginForm.do");
	   }
	   return mav;
	   }


	@Override
	@RequestMapping(value = "/member/logout.do", method =  RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");
		return mav;
	}	

	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
							  @RequestParam(value= "action", required=false) String action,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(viewName);
		HttpSession session = request.getSession();
		session.setAttribute("action", action);  
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value = "/member/selectInbodyValue.do", produces = "application/json; charset=utf8")
	@ResponseBody
	private ResponseEntity myPage(@RequestParam(value="mem_id") String mem_id, @RequestParam(value="start_date") String start_date, @RequestParam(value="end_date") String end_date, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("mem_id: " + mem_id);
		System.out.println("start_date: " + start_date);
		System.out.println("end_date: " + end_date);
		
		HashMap params = new HashMap();
		params.put("mem_id", mem_id);
		params.put("start_date", start_date);
		params.put("end_date", end_date);
		
		ArrayList<HashMap> hmList = new ArrayList<HashMap>();
			
		List<InbodyVO> inbodyList = memberService.inbodyList(params);
		
		if(inbodyList.size() > 0) {
			
			for(int i=0; i<inbodyList.size(); i++) {
				
				HashMap hm = new HashMap();
				
				hm.put("body_idx", inbodyList.get(i).getBody_idx());
				hm.put("mem_id", inbodyList.get(i).getMem_id());
				hm.put("write_date", inbodyList.get(i).getWrite_date());
				hm.put("weight", inbodyList.get(i).getWeight());
				hm.put("muscle", inbodyList.get(i).getMuscle());
				hm.put("body_fat",inbodyList.get(i).getBody_fat());
				
				hmList.add(hm);
				System.out.println("hmList: " + hmList);
			}
			
			JSONArray json = new JSONArray(hmList);
			
			return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
		}
		
		else {

			HashMap hm = new HashMap<String, Boolean>();

			hm.put("data", false);

			hmList.add(hm);

			JSONArray json = new JSONArray(hmList);

			return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);

		}
		
		
	}
	
	/* 인바드 등록 */
	@RequestMapping(value = "/member/insertInbody.do")
	@ResponseBody

	public String insertInbody(@RequestParam(value = "mem_id") String mem_id,
			@RequestParam(value = "weight") double weight, @RequestParam(value = "muscle") double muscle,
			@RequestParam(value = "body_fat") double body_fat, @RequestParam(value = "today") String today, HttpServletRequest request) throws Exception {
		
		String recentDate = null;
		
		try {
			
			recentDate = memberService.getRecentDate(mem_id);
			if(!recentDate.equals(today)) {
	        	
	        	InbodyVO inbodyVO = new InbodyVO();
	        	
	        	inbodyVO.setBody_fat(body_fat);
	        	inbodyVO.setMem_id(mem_id);
	        	inbodyVO.setMuscle(muscle);
	        	inbodyVO.setWeight(weight);
	        	
	        	memberService.insertInbody(inbodyVO);
	        	return "success";
	        } else {
	        	return "fail";
	        }
		
		} catch (Exception e) {
			
			System.out.println("에러로 들어왔습니다.");
			InbodyVO inbodyVO = new InbodyVO();
        	
        	inbodyVO.setBody_fat(body_fat);
        	inbodyVO.setMem_id(mem_id);
        	inbodyVO.setMuscle(muscle);
        	inbodyVO.setWeight(weight);
        	
        	memberService.insertInbody(inbodyVO);
        	return "success";
		} 
	}
	

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}


}
