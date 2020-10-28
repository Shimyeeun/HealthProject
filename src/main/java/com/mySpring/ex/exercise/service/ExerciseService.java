package com.mySpring.ex.exercise.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mySpring.ex.exercise.vo.MovieVO;

public interface ExerciseService {
	public List<MovieVO> listMovies() throws Exception;
	public List<MovieVO> listMoviesChest() throws Exception;
	public List<MovieVO> listMoviesArm() throws Exception;
	public List<MovieVO> listMoviesBack() throws Exception;
	public List<MovieVO> listMoviesShoulder() throws Exception;
	public List<MovieVO> listMoviesLeg() throws Exception;
	public List<MovieVO> listMoviesRun() throws Exception;
	
	public int addNewMovie(Map movieMap) throws Exception;
	public void removeMovie(int movieNO) throws Exception;
}
