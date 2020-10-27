package com.mySpring.ex.exercise.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.exercise.vo.MovieVO;


public interface ExerciseDAO {
	public List selectAllMoviesList() throws DataAccessException;
	public int insertNewMovie(Map movieMap) throws DataAccessException;	
	public MovieVO selectMovie(int movieNO) throws DataAccessException;
	public void deleteMovie(int movieNO) throws DataAccessException;
	
}
