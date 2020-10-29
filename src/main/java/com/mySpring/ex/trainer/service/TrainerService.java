package com.mySpring.ex.trainer.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mySpring.ex.trainer.vo.TrainerVO;

public interface TrainerService {
	public List<TrainerVO> listTrainers() throws Exception;
}
