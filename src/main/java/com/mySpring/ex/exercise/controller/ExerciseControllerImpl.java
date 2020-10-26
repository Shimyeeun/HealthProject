package com.mySpring.ex.exercise.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("exerciseController")
public class ExerciseControllerImpl implements ExerciseController{

	@Override //구현해야
	@RequestMapping(value = "/exercise/exerciseMain.do")
	public String exercise (HttpServletRequest request, HttpServletResponse response) {
		return "/exercise/exerciseMain";
	}
	public ModelAndView listMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}

}
