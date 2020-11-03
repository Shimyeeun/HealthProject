package com.mySpring.ex.exercise.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mySpring.ex.exercise.service.ExerciseService;
import com.mySpring.ex.exercise.vo.MovieVO;


@Controller("exerciseController")
public class ExerciseControllerImpl implements ExerciseController{
	
	@Autowired     
	private ExerciseService exerciseService;
	@Autowired
	private MovieVO movieVO;
	
	@RequestMapping(value = { "/count/countMachine.do"}, method = RequestMethod.GET)	
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value= "/exercise/exerciseMain.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List moviesList = exerciseService.listMovies();
		System.out.println("moviesList(0): " + moviesList.get(0));
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("moviesList", moviesList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/exercise/addNewMovie.do" ,method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewMovie(MultipartHttpServletRequest multipartRequest, 
	HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String,Object> movieMap = new HashMap<String, Object>();
		Enumeration enu=multipartRequest.getParameterNames();
		while(enu.hasMoreElements()){
			String name=(String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			movieMap.put(name,value);
		}
		
		HttpSession session = multipartRequest.getSession();
		
		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int articleNO = exerciseService.addNewMovie(movieMap);
	
			message = "<script>";
			message += " alert('�깉湲��쓣 異붽��뻽�뒿�땲�떎.');";
			message += " location.href='"+multipartRequest.getContextPath()+"/exercise/listMovies.do'; ";
			message +=" </script>";
		    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = " <script>";
			message +=" alert('�삤瑜섍� 諛쒖깮�뻽�뒿�땲�떎. �떎�떆 �떆�룄�빐 二쇱꽭�슂');');";
			message +=" location.href='"+multipartRequest.getContextPath()+"/exercise/movieForm.do'; ";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

  
  @Override
  @RequestMapping(value="/exercise/removeMovie.do" ,method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity  removeMovie(@RequestParam("movieNO") int movieNO,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
	response.setContentType("text/html; charset=UTF-8");
	String message;
	ResponseEntity resEnt=null;
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	try {
		exerciseService.removeMovie(movieNO);
		
		message = "<script>";
		message += " alert('湲��쓣 �궘�젣�뻽�뒿�땲�떎.');";
		message += " location.href='"+request.getContextPath()+"/exercise/listMovies.do';";
		message +=" </script>";
	    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	       
	}catch(Exception e) {
		message = "<script>";
		message += " alert('�옉�뾽以� �삤瑜섍� 諛쒖깮�뻽�뒿�땲�떎.�떎�떆 �떆�룄�빐 二쇱꽭�슂.');";
		message += " location.href='"+request.getContextPath()+"/exercise/listMovies.do';";
		message +=" </script>";
	    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	    e.printStackTrace();
	}
	return resEnt;
  }  
  /*
	@RequestMapping(value = "/exercise/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
*/
	@RequestMapping(value="/exercise/*Form.do", method = RequestMethod.GET)
	public String addMovie(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "exercise/addMovieForm.jsp";
	}
	
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute MovieVO vo) throws Exception{
		exerciseService.create(vo);
		return null;
		
	}

	@Override
	public String insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}
}