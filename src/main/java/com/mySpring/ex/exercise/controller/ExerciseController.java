package com.mySpring.ex.exercise.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


public interface ExerciseController {
	
	public ModelAndView listMovies(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addNewMovie(MultipartHttpServletRequest multipartRequest,HttpServletResponse response) throws Exception;
	public String exercise (HttpServletRequest request, HttpServletResponse response);
	public ModelAndView viewMovie(@RequestParam("movieNO") int movieNO,
			                        HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity removeMovie(@RequestParam("movieNO") int movieNO,
                              HttpServletRequest request, HttpServletResponse response) throws Exception;

}
