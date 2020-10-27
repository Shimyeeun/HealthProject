package com.mySpring.ex.exercise.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface ExerciseController {

	
	public ModelAndView listMovies(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public String exercise (HttpServletRequest request, HttpServletResponse response);
}
