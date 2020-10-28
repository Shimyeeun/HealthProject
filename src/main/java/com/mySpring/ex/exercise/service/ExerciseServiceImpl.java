package com.mySpring.ex.exercise.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.ex.exercise.dao.ExerciseDAO;
import com.mySpring.ex.exercise.vo.MovieVO;

@Service("exerciseService")
@Transactional(propagation = Propagation.REQUIRED)
public class ExerciseServiceImpl  implements ExerciseService{
	@Autowired
	ExerciseDAO exerciseDAO;
	
	public List<MovieVO> listMovies() throws Exception{
		List<MovieVO> moviesList =  exerciseDAO.selectAllMoviesList();
        return moviesList;
	}
	
	public List<MovieVO> listMoviesChest() throws Exception{
		List<MovieVO> moviesList =  exerciseDAO.selectMoviesListChest();
        return moviesList;
	}
	
	public List<MovieVO> listMoviesArm() throws Exception{
		List<MovieVO> moviesList =  exerciseDAO.selectMoviesListArm();
        return moviesList;
	}
	
	public List<MovieVO> listMoviesBack() throws Exception{
		List<MovieVO> moviesList =  exerciseDAO.selectMoviesListBack();
        return moviesList;
	}
	
	public List<MovieVO> listMoviesShoulder() throws Exception{
		List<MovieVO> moviesList =  exerciseDAO.selectMoviesListShoulder();
        return moviesList;
	}
	
	public List<MovieVO> listMoviesLeg() throws Exception{
		List<MovieVO> moviesList =  exerciseDAO.selectMoviesListLeg();
        return moviesList;
	}
	
	public List<MovieVO> listMoviesRun() throws Exception{
		List<MovieVO> moviesList =  exerciseDAO.selectMoviesListRun();
        return moviesList;
	}

	@Override
	public int addNewMovie(Map movieMap) throws Exception{
		return exerciseDAO.insertNewMovie(movieMap);
	}
	
	
	@Override
	public void removeMovie(int movieNO) throws Exception {
		exerciseDAO.deleteMovie(movieNO);
	}
	
	
}
