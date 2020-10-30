package com.mySpring.ex.exercise.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mySpring.ex.exercise.vo.MovieVO;
public interface ExerciseService {
	public List<MovieVO> listMovies() throws Exception;
	public int addNewMovie(Map movieMap) throws Exception;
	public void removeMovie(int movieNO) throws Exception;
	public void create(MovieVO vo) throws Exception;
}
