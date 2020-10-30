package com.mySpring.ex.trainer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.trainer.vo.TrainerVO;



public interface TrainerController {
	public ModelAndView listTrainers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addTrainer(@ModelAttribute("info") TrainerVO trainerVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(@ModelAttribute("trainer") TrainerVO trainer,
            RedirectAttributes rAttr,
            HttpServletRequest request, HttpServletResponse response) throws Exception;
}
