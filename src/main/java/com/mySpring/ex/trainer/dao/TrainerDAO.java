package com.mySpring.ex.trainer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface TrainerDAO {
	public List selectAllTrainersList() throws DataAccessException;
}
