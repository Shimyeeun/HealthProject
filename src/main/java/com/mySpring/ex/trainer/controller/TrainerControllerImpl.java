package com.mySpring.ex.trainer.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.common.file.UploadFileUtils;
import com.mySpring.ex.member.vo.MemberVO;
import com.mySpring.ex.trainer.service.TrainerService;
import com.mySpring.ex.trainer.vo.TrainerVO;

@Controller("trainerController")
public class TrainerControllerImpl implements TrainerController {
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
    TrainerVO trainerVO;
	
	
	
	@Override
	@RequestMapping(value= "/trainer/listTrainers.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listTrainers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List trainersList = trainerService.listTrainers();
		System.out.println("trainersList(0): " + trainersList.get(0));
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("trainersList", trainersList);
		return mav;
	}
	  @Resource(name="uploadPath")
      private String uploadPath;
	  
	  @Override
	  @RequestMapping(value="/trainer/addTrainer.do" ,method = RequestMethod.POST)
	  public ModelAndView addTrainer(@ModelAttribute("trainer") TrainerVO trainer,
			  MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = null;
		  if(file != null) {
			  fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			 } else {
			  fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
			 }

			 trainer.settrainer_img(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			 trainer.setTrainer_thumbimg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  request.setCharacterEncoding("utf-8"); 
		  int result = 0; result =trainerService.addTrainer(trainer); 
		  ModelAndView mav = new ModelAndView("redirect:/member/loginForm.do"); 
		  return mav; 
	}
	  @RequestMapping(value="/trainer/updateTrainer.do",method = {RequestMethod.GET})
	   public ModelAndView updateTrainer (@RequestParam("mgr_id") String mgr_id, @RequestParam("mem_id") String mem_id,
	            HttpServletRequest request, HttpServletResponse response) throws Exception{
	         MemberVO memberVO=new MemberVO();
	         memberVO.setMem_id(mem_id);
	         memberVO.setMgr_id(mgr_id);
	         System.out.println("컨트롤러"+mgr_id);
	         trainerService.updateTrainer(memberVO);
	         
	         String viewName=(String)request.getAttribute("viewName");
	         ModelAndView mav = new ModelAndView("redirect:/trainer/listTrainers.do");
	         return mav;
	   } 
	
	@RequestMapping(value = "/trainer/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
							  @RequestParam(value= "action", required=false) String action,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(viewName);
		HttpSession session = request.getSession();
		session.setAttribute("action", action);  
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	@Override
	public ModelAndView login(TrainerVO trainer, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
