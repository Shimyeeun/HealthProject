package com.mySpring.ex.exercise.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.ex.exercise.vo.MovieVO;


@Repository("exerciseDAO")
public class ExerciseDAOImpl implements ExerciseDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMoviesList() throws DataAccessException {
		List<MovieVO> moviesList  = sqlSession.selectList("mapper.exercise.selectAllMoviesList");
		System.out.println("exercise_idx: " + moviesList.get(0).getMovie_idx());
		return moviesList;
	}

	
	@Override
	public int insertNewMovie(Map movieMap) throws DataAccessException {
		int movieNO = selectNewMovieNO();
		movieMap.put("movieNO", movieNO);
		sqlSession.insert("mapper.exercise.insertNewmovie",movieMap);
		return movieNO;
	}
    
	
	@Override
	public MovieVO selectMovie(int exercise_idx) throws DataAccessException {
		return sqlSession.selectOne("mapper.exercise.selectMovie", exercise_idx);
	}


	@Override
	public void deleteMovie(int movieNO) throws DataAccessException {
		sqlSession.delete("mapper.exercise.deleteMovie", movieNO);
		
	}
	
	private int selectNewMovieNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.exercise.selectNewMovieNO");
	}
	
}
