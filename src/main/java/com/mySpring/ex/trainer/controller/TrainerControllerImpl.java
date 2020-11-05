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
		
		HttpSession session=request.getSession();
		Boolean logincheck=(Boolean)session.getAttribute("isLogOn");
		session.getAttribute("member");
		System.out.println();
		if(logincheck==null) {
			session.setAttribute("isLogOn",false);
		}
		
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
		  
		  String imgUploadPath = request.getSession().getServletContext().getRealPath("resources/imgUpload");
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
	         HttpSession session=request.getSession();
		  	 MemberVO memberVO=new MemberVO();
		  	 MemberVO memberVO2=new MemberVO();
	         memberVO.setMem_id(mem_id);
	         memberVO.setMgr_id(mgr_id);
	         System.out.println("컨트롤러"+mgr_id);
	         trainerService.updateTrainer(memberVO);
	         memberVO2=trainerService.selectMember(mem_id);
	         session.setAttribute("member",memberVO2);
	         String viewName=(String)request.getAttribute("viewName");
	         ModelAndView mav = new ModelAndView("redirect:/trainer/listTrainers.do");
	         return mav;
	   } 
	  @Override
	   @RequestMapping(value = "/trainer/login.do", method = RequestMethod.POST)
	   public ModelAndView login(@ModelAttribute("trainer") TrainerVO trainer,
	                          RedirectAttributes rAttr,
	                             HttpServletRequest request, HttpServletResponse response) throws Exception {

	      System.out.println("mgr_id: " + request.getParameter("mgr_id"));
	      System.out.println("mgr_pw: " + request.getParameter("mgr_pw"));
	      
	      TrainerVO trainerVO2 = new TrainerVO();
	      
	      trainerVO2.setMgr_id(request.getParameter("mgr_id"));
	      trainerVO2.setMgr_pw(request.getParameter("mgr_pw"));
	      
	      ModelAndView mav = new ModelAndView();
	      trainerVO = trainerService.login(trainerVO2);
	   if(trainerVO != null) {  //memberVO 정보를 db와 비교해서 있으면
	       HttpSession session = request.getSession();
	       //session 객체의 setAtrribute메서드를 사용해 member에 속성값으로 MemberVO를 할당
	       session.setAttribute("trainer", trainerVO);
	       //session 객체의 setAttribute메서드를 사용해 isLogOn은 true를 할당
	       session.setAttribute("isLogOn", true);  //login  셿猷 
	       //mav.setViewName("redirect:/member/listMembers.do");
	       //session 객체의 getAttribute메서드를 사용해 속성명이 action인 속성의 값을 String 타입으로 변환 
	       //String 타입으로 변환한것을 action 변수에 담아 
	       String action = (String)session.getAttribute("action");
	       //sesion 객체의 removeAttribute메서드를 사용해 action의 속성을 삭제 
	    
	       session.removeAttribute("action");
	       if(action!= null) {
	          mav.setViewName("redirect:"+action);
	       }else {
	          mav.setViewName("redirect:/main.do");   
	       }

	   }else {  //memberVO 정보를 db와 비교해서 없으면
	      rAttr.addAttribute("result","loginFailed");
	      mav.setViewName("redirect:/member/loginForm.do");
	   }
	   return mav;
	   }
	 @Override
		@RequestMapping(value = "/trainer/logout.do", method =  RequestMethod.GET)
		public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
			HttpSession session = request.getSession();
			session.removeAttribute("trainer");
			session.removeAttribute("isLogOn");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/main.do");
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

	
}
