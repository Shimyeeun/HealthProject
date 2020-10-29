package com.mySpring.ex.trainer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mySpring.ex.trainer.service.TrainerService;
import com.mySpring.ex.trainer.vo.TrainerVO;

@Controller("trainerController")
public class TrainerControllerImpl implements TrainerController {
	@Autowired
	private TrainerService trainerService;
	@Autowired
	private TrainerVO trainerVO;

	@Override
	@RequestMapping(value= "/trainer/listTrainers.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listTrainers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List trainersList = trainerService.listTrainers();
		System.out.println("trainersList(0): " + trainersList.get(0));
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("trainersList", trainersList);
		return mav;
	}
}
