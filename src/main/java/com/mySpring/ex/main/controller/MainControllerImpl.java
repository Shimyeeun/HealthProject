package com.mySpring.ex.main.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mySpring.ex.main.service.MainService;
import com.mySpring.ex.member.vo.MemberVO;



@Controller("mainController")
public class MainControllerImpl implements MainController{
	@Autowired
	private MainService mainService;
	
	
	@RequestMapping(value = {"/main.do"}, method = RequestMethod.GET)	
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO memberVO =new MemberVO();
		HttpSession session=request.getSession();
		Boolean logincheck=(Boolean)session.getAttribute("isLogOn");
		session.getAttribute("member");	
		
		memberVO.setMgr_id(request.getParameter("mgr_id"));
		

		System.out.println();
		if(logincheck==null) {
			session.setAttribute("isLogOn",false);
		}
		
		
		String viewName = (String)request.getAttribute("viewName");
		List maintrainersList = mainService.listTrainers();
		System.out.println("메인컨트롤러");
		ModelAndView mav = new ModelAndView();
		mav.addObject("maintrainersList",maintrainersList);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/main/updateMainTrainer.do",method = {RequestMethod.GET, RequestMethod.POST})
	   public ModelAndView updateMainTrainer (@ModelAttribute("member") MemberVO member,@RequestParam("mgr_id") String mgr_id, @RequestParam("mem_id") String mem_id,
	         HttpServletRequest request, HttpServletResponse response) throws Exception{
			 
		  	MemberVO memberVO=new MemberVO();
		    HttpSession session=request.getSession();
	        System.out.println(member.getMgr_id()+" "+member.getName());
	        mainService.updateMainTrainer(member);
	        memberVO=mainService.selectMember(mem_id);
			
			System.out.println(memberVO.getMgr_id()+" "+memberVO.getName());
			session.setAttribute("member", memberVO);
			
			String viewName=(String)request.getAttribute("viewName");
	        ModelAndView mav = new ModelAndView("redirect:/main.do");
	        return mav;
			
	   } 
	
}
