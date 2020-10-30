package com.mySpring.ex.challenge.controller;


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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mySpring.ex.challenge.service.ChallengeService;
import com.mySpring.ex.challenge.vo.ChallengeVO;

@Controller ("challengeController")
public class ChallengeControllerImpl implements ChallengeController {
	//private static final String ARTICLE_IMAGE_REPO = "D:\\board\\article_image";
	@Autowired    //�옄�룞�쑝濡� 二쇱엯 
	private ChallengeService challengeService;
	@Autowired
	private ChallengeVO challengeVO;
	
	@Override
	@RequestMapping(value= "/challenge/listChallenges.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listChallenges(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List challengesList = challengeService.listChallenges();
		System.out.println("challengesList(0): " + challengesList.get(0));
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("challengesList", challengesList);
		return mav;	
	}
	
	@RequestMapping(value= "/challenge/updateChallenge.do", method = {RequestMethod.GET})
	public ModelAndView updateChallenge (@RequestParam("chal_idx") int chal_idx,
            HttpServletRequest request, HttpServletResponse response) throws Exception{
			challengeService.updateChallenges(chal_idx);
			challengeService.updateChalState(chal_idx);
			String viewName=(String)request.getAttribute("viewName");
	
			ModelAndView mav = new ModelAndView("redirect:/challenge/listChallenges.do");
			return mav;
}
	
	
}
