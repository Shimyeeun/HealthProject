package com.mySpring.ex.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mySpring.ex.member.vo.MemberVO;

public interface MainController {
	@RequestMapping(value = {"/main.do"}, method = RequestMethod.GET)	
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateMainTrainer(@ModelAttribute("member") MemberVO member,@RequestParam("mgr_id") String mgr_id, @RequestParam("mem_id") String mem_id,
			 HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
