package com.mySpring.ex.challenge.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface ChallengeController {
	public ModelAndView listChallenges(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//public ModelAndView updateChallenge(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//public ResponseEntity applyChallenge(MultipartHttpServletRequest multipartRequest,HttpServletResponse response) throws Exception;
	
	public ModelAndView updateChallenge(@RequestParam("chal_idx") int chal_idx,@RequestParam("mem_id") String mem_id,
		                        HttpServletRequest request, HttpServletResponse response) throws Exception;
	

}
