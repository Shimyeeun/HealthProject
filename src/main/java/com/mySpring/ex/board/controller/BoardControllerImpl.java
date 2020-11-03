package com.mySpring.ex.board.controller;

import java.io.File;

import java.util.ArrayList;

import java.util.Enumeration;

import java.util.HashMap;

import java.util.Iterator;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;

import org.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mySpring.ex.board.domain.CommentVO;

import com.mySpring.ex.board.service.BoardService;

import com.mySpring.ex.board.vo.ArticleVO;

import com.mySpring.ex.board.vo.ImageVO;

import com.mySpring.ex.common.file.UploadFileUtils;

import com.mySpring.ex.member.vo.MemberVO;

import com.mySpring.ex.member.service.MemberService;

@Controller("boardController")

public class BoardControllerImpl implements BoardController {

	private static final String ARTICLE_IMAGE_REPO = "D:\\board\\article_image";

	@Autowired // 옄 룞 쑝濡 二쇱엯

	private BoardService boardService;
	private MemberService memberService;

	@Autowired

	private ArticleVO articleVO;

	@Resource(name = "uploadPath")

	private String uploadPath;

	@Override

	@RequestMapping(value = "/board/listArticles.do", method = { RequestMethod.GET, RequestMethod.POST })

	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String viewName = (String) request.getAttribute("viewName");

		List<ArticleVO> articlesList = boardService.listArticles();

		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");

		if (memberVO != null) {
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("articlesList", articlesList);
			mav.addObject("member", memberVO);
			session.setAttribute("isLogOn", true);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("articlesList", articlesList);
			session.setAttribute("isLogOn", false);
			return mav;
		}

	}

	/*
	 * 
	 * //artcle 추가
	 * 
	 * @Override
	 * 
	 * @RequestMapping(value="/board/addNewArticle.do" ,method = RequestMethod.POST)
	 * 
	 * @ResponseBody
	 * 
	 * public ResponseEntity addNewArticle(MultipartHttpServletRequest
	 * multipartRequest,
	 * 
	 * HttpServletResponse response) throws Exception {
	 * 
	 * multipartRequest.setCharacterEncoding("utf-8");
	 * 
	 * Map<String,Object> articleMap = new HashMap<String, Object>();
	 * 
	 * Enumeration enu=multipartRequest.getParameterNames();
	 * 
	 * while(enu.hasMoreElements()){
	 * 
	 * String name=(String)enu.nextElement();
	 * 
	 * String value=multipartRequest.getParameter(name);
	 * 
	 * articleMap.put(name,value);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * String imageFileName= upload(multipartRequest);
	 * 
	 * HttpSession session = multipartRequest.getSession();
	 * 
	 * MemberVO memberVO = (MemberVO) session.getAttribute("member");
	 * 
	 * String id = memberVO.getMem_id();
	 * 
	 * articleMap.put("parentNO", 0);
	 * 
	 * articleMap.put("id", id);
	 * 
	 * articleMap.put("imageFileName", imageFileName);
	 * 
	 * 
	 * 
	 * String message;
	 * 
	 * ResponseEntity resEnt=null;
	 * 
	 * HttpHeaders responseHeaders = new HttpHeaders();
	 * 
	 * responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	 * 
	 * try {
	 * 
	 * int articleNO = boardService.addNewArticle(articleMap);
	 * 
	 * if(imageFileName!=null && imageFileName.length()!=0) {
	 * 
	 * File srcFile = new
	 * 
	 * File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
	 * 
	 * File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
	 * 
	 * FileUtils.moveFileToDirectory(srcFile, destDir,true);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * message = "<script>";
	 * 
	 * message += " alert(' 깉湲  쓣 異붽  뻽 뒿 땲 떎.');";
	 * 
	 * message += " location.href='"+multipartRequest.getContextPath()
	 * +"/board/listArticles.do'; ";
	 * 
	 * message +=" </script>";
	 * 
	 * resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	 * 
	 * }catch(Exception e) {
	 * 
	 * File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
	 * 
	 * srcFile.delete();
	 * 
	 * 
	 * 
	 * message = " <script>";
	 * 
	 * message +=" alert(' 삤瑜섍  諛쒖깮 뻽 뒿 땲 떎.  떎 떆  떆 룄 빐 二쇱꽭 슂');');";
	 * 
	 * message +=" location.href='"+multipartRequest.getContextPath()
	 * +"/board/articleForm.do'; ";
	 * 
	 * message +=" </script>";
	 * 
	 * resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * return resEnt;
	 * 
	 * }
	 * 
	 */

	// 게시글 상세보기

	@RequestMapping(value = "/board/viewArticle.do", method = RequestMethod.GET)

	public ModelAndView viewArticle(@RequestParam("board_idx") int board_idx,

			HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String viewName = (String) request.getAttribute("viewName");
		String login_id = null;
		MemberVO memberVO;
		if ((MemberVO) session.getAttribute("member") != null) {
			memberVO = (MemberVO) session.getAttribute("member");
			login_id = memberVO.getMem_id();
			System.out.println("login_id: " + login_id);

		} else {
			memberVO = null;
		}

		articleVO = boardService.viewArticle(board_idx);
		boardService.articleCntIncrease(board_idx);
		String str = articleVO.getBoard_img();
		int find = str.lastIndexOf('.');
		String stringName = articleVO.getBoard_img().substring(find, str.length());
		if (stringName.equals(".none")) {
			articleVO.setBoard_img(null);
		}

		ModelAndView mav = new ModelAndView();

		mav.setViewName(viewName);

		mav.addObject("article", articleVO);
		mav.addObject("login_id", login_id);

		// mav.addObject("commentList",commentList);

		return mav;

	}

	// 게시글 수정

	@RequestMapping(value = "/board/modArticle.do", method = RequestMethod.GET)

	@ResponseBody

	public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,

			HttpServletResponse response) throws Exception {

		multipartRequest.setCharacterEncoding("utf-8");

		Map<String, Object> articleMap = new HashMap<String, Object>();

		Enumeration enu = multipartRequest.getParameterNames();

		while (enu.hasMoreElements()) {

			String name = (String) enu.nextElement();

			String value = multipartRequest.getParameter(name);

			articleMap.put(name, value);

		}

		String imageFileName = upload(multipartRequest);

		HttpSession session = multipartRequest.getSession();

		MemberVO memberVO = (MemberVO) session.getAttribute("member");

		String id = memberVO.getMem_id();

		articleMap.put("id", id);

		articleMap.put("imageFileName", imageFileName);

		String articleNO = (String) articleMap.get("articleNO");

		String message;

		ResponseEntity resEnt = null;

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		try {

			boardService.modArticle(articleMap);

			if (imageFileName != null && imageFileName.length() != 0) {

				File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);

				File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);

				FileUtils.moveFileToDirectory(srcFile, destDir, true);

				String originalFileName = (String) articleMap.get("originalFileName");

				File oldFile = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + originalFileName);

				oldFile.delete();

			}

			message = "<script>";

			message += " alert('湲  쓣  닔 젙 뻽 뒿 땲 떎.');";

			message += " location.href='" + multipartRequest.getContextPath() + "/board/viewArticle.do?articleNO="
					+ articleNO + "';";

			message += " </script>";

			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {

			File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);

			srcFile.delete();

			message = "<script>";

			message += " alert(' 삤瑜섍  諛쒖깮 뻽 뒿 땲 떎. 떎 떆  닔 젙 빐二쇱꽭 슂');";

			message += " location.href='" + multipartRequest.getContextPath() + "/board/viewArticle.do?articleNO="
					+ articleNO + "';";

			message += " </script>";

			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		}

		return resEnt;

	}

	@Override

	@RequestMapping(value = "/board/removeArticle.do", method = RequestMethod.POST)

	@ResponseBody

	public ResponseEntity removeArticle(@RequestParam("articleNO") int articleNO,

			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html; charset=UTF-8");

		String message;

		ResponseEntity resEnt = null;

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		try {

			boardService.removeArticle(articleNO);

			File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);

			FileUtils.deleteDirectory(destDir);

			message = "<script>";

			message += " alert('湲  쓣  궘 젣 뻽 뒿 땲 떎.');";

			message += " location.href='" + request.getContextPath() + "/board/listArticles.do';";

			message += " </script>";

			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {

			message = "<script>";

			message += " alert(' 옉 뾽以   삤瑜섍  諛쒖깮 뻽 뒿 땲 떎. 떎 떆  떆 룄 빐 二쇱꽭 슂.');";

			message += " location.href='" + request.getContextPath() + "/board/listArticles.do';";

			message += " </script>";

			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

			e.printStackTrace();

		}

		return resEnt;

	}

	/*
	 * 
	 * // 떎以 씠誘몄 湲 異붽 븯湲
	 * 
	 * @Override
	 * 
	 * @RequestMapping(value="/board/addNewArticle.do" ,method = RequestMethod.POST)
	 * 
	 * @ResponseBody
	 * 
	 * public ResponseEntity addNewArticle(MultipartHttpServletRequest
	 * multipartRequest, HttpServletResponse response) throws Exception {
	 * 
	 * multipartRequest.setCharacterEncoding("utf-8");
	 * 
	 * String imageFileName=null;
	 * 
	 * 
	 * 
	 * Map articleMap = new HashMap();
	 * 
	 * Enumeration enu=multipartRequest.getParameterNames();
	 * 
	 * while(enu.hasMoreElements()){
	 * 
	 * String name=(String)enu.nextElement();
	 * 
	 * String value=multipartRequest.getParameter(name);
	 * 
	 * articleMap.put(name,value);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * //회원정보 가져오기
	 * 
	 * HttpSession session = multipartRequest.getSession();
	 * 
	 * MemberVO memberVO = (MemberVO) session.getAttribute("member");
	 * 
	 * String id = memberVO.getId();
	 * 
	 * articleMap.put("id",id);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * List<String> fileList =upload(multipartRequest);
	 * 
	 * List<ImageVO> imageFileList = new ArrayList<ImageVO>();
	 * 
	 * if(fileList!= null && fileList.size()!=0) {
	 * 
	 * for(String fileName : fileList) {
	 * 
	 * ImageVO imageVO = new ImageVO();
	 * 
	 * imageVO.setImageFileName(fileName);
	 * 
	 * imageFileList.add(imageVO);
	 * 
	 * }
	 * 
	 * articleMap.put("imageFileList", imageFileList);
	 * 
	 * }
	 * 
	 * String message;
	 * 
	 * ResponseEntity resEnt=null;
	 * 
	 * HttpHeaders responseHeaders = new HttpHeaders();
	 * 
	 * responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	 * 
	 * try {
	 * 
	 * int articleNO = boardService.addNewArticle(articleMap);
	 * 
	 * if(imageFileList!=null && imageFileList.size()!=0) {
	 * 
	 * for(ImageVO imageVO:imageFileList) {
	 * 
	 * imageFileName = imageVO.getImageFileName();
	 * 
	 * File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
	 * 
	 * File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
	 * 
	 * //destDir.mkdirs();
	 * 
	 * FileUtils.moveFileToDirectory(srcFile, destDir,true);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * message = "<script>";
	 * 
	 * message += " alert(' 깉湲  쓣 異붽  뻽 뒿 땲 떎.');";
	 * 
	 * message += " location.href='"+multipartRequest.getContextPath()
	 * +"/board/listArticles.do'; ";
	 * 
	 * message +=" </script>";
	 * 
	 * resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }catch(Exception e) {
	 * 
	 * if(imageFileList!=null && imageFileList.size()!=0) {
	 * 
	 * for(ImageVO imageVO:imageFileList) {
	 * 
	 * imageFileName = imageVO.getImageFileName();
	 * 
	 * File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
	 * 
	 * srcFile.delete();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * message = " <script>";
	 * 
	 * message +=" alert(' 삤瑜섍  諛쒖깮 뻽 뒿 땲 떎.  떎 떆  떆 룄 빐 二쇱꽭 슂');');";
	 * 
	 * message +=" location.href='"+multipartRequest.getContextPath()
	 * +"/board/articleForm.do'; ";
	 * 
	 * message +=" </script>";
	 * 
	 * resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * return resEnt;
	 * 
	 * }
	 * 
	 * 
	 * 
	 */

	@RequestMapping(value = "/board/*Form.do", method = RequestMethod.GET)

	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String viewName = (String) request.getAttribute("viewName");

		ModelAndView mav = new ModelAndView();

		mav.setViewName(viewName);

		return mav;

	}

	// 븳媛 씠誘몄 뾽濡쒕뱶 븯湲

	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception {

		String imageFileName = null;

		Iterator<String> fileNames = multipartRequest.getFileNames();

		while (fileNames.hasNext()) {

			String fileName = fileNames.next();

			MultipartFile mFile = multipartRequest.getFile(fileName);

			imageFileName = mFile.getOriginalFilename();

			File file = new File(ARTICLE_IMAGE_REPO + "\\" + fileName);

			if (mFile.getSize() != 0) { // File Null Check

				if (!file.exists()) { // 寃쎈줈 긽 뿉 뙆 씪 씠 議댁옱 븯吏 븡 쓣 寃쎌슦

					if (file.getParentFile().mkdirs()) { // 寃쎈줈 뿉 빐 떦 븯 뒗 뵒 젆 넗由щ뱾 쓣 깮 꽦

						file.createNewFile(); // 씠 썑 뙆 씪 깮 꽦

					}

				}

				mFile.transferTo(new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName)); // 엫 떆濡 옣 맂
																										// multipartFile
																										// 쓣 떎 젣 뙆 씪濡 쟾
																										// 넚

			}

		}

		return imageFileName;

	}

	/* 댓글 리스트 */

	/*
	 * 
	 * // 떎以 씠誘몄 뾽濡쒕뱶 븯湲
	 * 
	 * private List<String> upload(MultipartHttpServletRequest multipartRequest)
	 * throws Exception{
	 * 
	 * List<String> fileList= new ArrayList<String>();
	 * 
	 * Iterator<String> fileNames = multipartRequest.getFileNames();
	 * 
	 * while(fileNames.hasNext()){
	 * 
	 * String fileName = fileNames.next();
	 * 
	 * MultipartFile mFile = multipartRequest.getFile(fileName);
	 * 
	 * String originalFileName=mFile.getOriginalFilename();
	 * 
	 * fileList.add(originalFileName);
	 * 
	 * File file = new File(ARTICLE_IMAGE_REPO +"\\"+ fileName);
	 * 
	 * if(mFile.getSize()!=0){ //File Null Check
	 * 
	 * if(! file.exists()){ //寃쎈줈 긽 뿉 뙆 씪 씠 議댁옱 븯吏 븡 쓣 寃쎌슦
	 * 
	 * if(file.getParentFile().mkdirs()){ //寃쎈줈 뿉 빐 떦 븯 뒗 뵒 젆 넗由щ뱾 쓣 깮 꽦
	 * 
	 * file.createNewFile(); // 씠 썑 뙆 씪 깮 꽦
	 * 
	 * }
	 * 
	 * }
	 * 
	 * mFile.transferTo(new File(ARTICLE_IMAGE_REPO
	 * +"\\"+"temp"+ "\\"+originalFileName)); // 엫 떆濡 옣 맂 multipartFile 쓣 떎 젣 뙆 씪濡 쟾
	 * 넚
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return fileList;
	 * 
	 * }
	 * 
	 */

	/**
	 * 
	 * 게시물 댓글 불러오기(Ajax)
	 * 
	 * @param boardVO
	 * 
	 * @param request
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 */

	/* 댓글 등록 */

	@RequestMapping(value = "/board/addComment.do")

	@ResponseBody

	public String ajax_addComment(@RequestParam(value = "mem_id") String mem_id,
			@RequestParam(value = "board_idx") int board_idx, @RequestParam(value = "comment") String comment,
			HttpServletRequest request) throws Exception {

		CommentVO commentVO = new CommentVO();

		commentVO.setBoard_idx(board_idx);

		commentVO.setContent(comment);

		commentVO.setMem_id(mem_id);

		boardService.commentInsert(commentVO);

		return "success";

	}

	@Override

	@RequestMapping(value = "/board/commentList.do", produces = "application/json; charset=utf8")

	@ResponseBody

	public ResponseEntity ajax_commentList(@RequestParam(value = "board_idx") int board_idx, HttpServletRequest request)
			throws Exception {

		HttpHeaders responseHeaders = new HttpHeaders();

		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();

		List<CommentVO> commentList = boardService.commentList(board_idx);

		if (commentList.size() > 0) {

			for (int i = 0; i < commentList.size(); i++) {

				HashMap hm = new HashMap();

				hm.put("comment_idx", commentList.get(i).getComment_idx());

				hm.put("comment", commentList.get(i).getContent());

				hm.put("mem_id", commentList.get(i).getMem_id());

				hm.put("reg_date", commentList.get(i).getReg_date());

				hmlist.add(hm);

			}

			JSONArray json = new JSONArray(hmlist);

			return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);

		}

		else {

			HashMap hm = new HashMap<String, Boolean>();

			hm.put("data", false);

			hmlist.add(hm);

			JSONArray json = new JSONArray(hmlist);

			return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);

		}

	}

	@Override

	@RequestMapping(value = "/board/updateComment.do")

	@ResponseBody

	public String ajax_commentUpdate(@RequestParam(value = "comment_idx") int comment_idx,
			@RequestParam(value = "comment") String comment, HttpServletRequest request) throws Exception {

		CommentVO commentVO = new CommentVO();

		commentVO.setComment_idx(comment_idx);

		commentVO.setContent(comment);

		System.out.println("수정할 코멘트" + commentVO.getContent());

		boardService.commentUpdate(commentVO);

		return "success";

	}

	@Override

	@RequestMapping(value = "/board/deleteComment.do")

	@ResponseBody

	public String ajax_commentDelete(@RequestParam(value = "comment_idx") int comment_idx, HttpServletRequest request)
			throws Exception {

		System.out.println("삭제할 comment_idx:" + comment_idx);

		boardService.commentDelete(comment_idx);

		return "success";

	}

	@Override

	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)

			throws Exception {

		// TODO Auto-generated method stub

		return null;

	}

	/*
	 * 
	 * @Override
	 * 
	 * @RequestMapping(value= "/board/listArticles.do", method = {RequestMethod.GET,
	 * RequestMethod.POST})
	 * 
	 * public ModelAndView listArticles(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * String viewName = (String)request.getAttribute("viewName");
	 * 
	 * List articlesList = boardService.listArticles();
	 * 
	 * 
	 * 
	 * ModelAndView mav = new ModelAndView(viewName);
	 * 
	 * mav.addObject("articlesList", articlesList);
	 * 
	 * return mav;
	 * 
	 * 
	 * 
	 * }
	 * 
	 */

	@Override

	@RequestMapping(value = "/board/boardForm.do", method = { RequestMethod.GET, RequestMethod.POST })

	public ModelAndView boardForm(@ModelAttribute("member") MemberVO member,
			@ModelAttribute("articleVO") ArticleVO articleVO, Model model, RedirectAttributes rttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");

		if (memberVO != null) {
			System.out.println("글쓰기 권한이 있습니다!!!");
			System.out.println("memberVO.getMem_id()" + memberVO.getMem_id());
			String viewName = (String) request.getAttribute("viewName");

			ModelAndView mav = new ModelAndView();
			mav.addObject(articleVO);

			mav.setViewName(viewName);

			return mav;
		} else {
			System.out.println("글쓰기 권한이 없습니다.!!!");
			String viewName = (String) request.getAttribute("viewName");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/member/loginForm.do");

			return mav;
		}

	}

	@Override

	@RequestMapping(value = "/board/saveBoard.do", method = { RequestMethod.GET, RequestMethod.POST })

	public String saveBoard(@ModelAttribute("ArticleVO") ArticleVO articleVO, @RequestParam("mode") String mode,
			@RequestParam("board_idx") int board_idx, HttpServletRequest req, @RequestParam("file") MultipartFile file,
			RedirectAttributes rttr) throws Exception {

		if (mode.equals("edit")) {

			System.out.println("file: " + file);

			System.out.println("hello modify!!!");

			// StringBuilder sb = new StringBuilder(articleVO.getContent());

			// sb.delete(0, 3);

			// int sbLen = sb.length();

			// sb.delete(sbLen-4, sbLen);

			// articleVO.setContent(sb.toString());

			// 새로운 파일이 등록되었는지 확인

			if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {

				// 기존 파일을 삭제

				new File(uploadPath + req.getParameter("board_img")).delete();

				new File(uploadPath + req.getParameter("board_thumbImg")).delete();

				// 새로 첨부한 파일을 등록

				String imgUploadPath = uploadPath + File.separator + "imgUpload";

				String ymdPath = UploadFileUtils.calcPath(imgUploadPath);

				String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(),
						ymdPath);

				articleVO.setBoard_img(File.separator + "imgUpload" + ymdPath + File.separator + fileName);

				articleVO.setBoard_thumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s"
						+ File.separator + "s_" + fileName);

			} else { // 새로운 파일이 등록되지 않았다면

				System.out.println("새로운 파일이 등록되지 않았어요!");

				System.out.println("board_idx " + board_idx);

				// 기존 이미지를 그대로 사용

				ArticleVO originArticle = boardService.viewArticle(board_idx);

				articleVO.setBoard_img(originArticle.getBoard_img());

				articleVO.setBoard_thumbImg(originArticle.getBoard_thumbImg());

			}

			boardService.updateBoard(articleVO);

		} else {

			System.out.println("hello newInsert!!!");

			System.out.println("file: " + file);

			String fileName2 = req.getParameter("file");

			System.out.println("fileName2: " + fileName2);

			// StringBuilder sb = new StringBuilder(articleVO.getContent());

			// sb.delete(0, 3);

			// int sbLen = sb.length();

			// sb.delete(sbLen-4, sbLen);

			// articleVO.setContent(sb.toString());

			String imgUploadPath = uploadPath + File.separator + "imgUpload";

			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);

			String fileName = null;

			if (!file.getOriginalFilename().equals("")) {

				fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(),
						ymdPath);

			} else {

				fileName = uploadPath + File.separator + "images" + File.separator + "none.none";

			}

			System.out.println("fileName:" + fileName);

			articleVO.setBoard_img(File.separator + "imgUpload" + ymdPath + File.separator + fileName);

			articleVO.setBoard_thumbImg(
					File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);

			boardService.addNewArticle(articleVO);

		}

		return "redirect:/board/listArticles.do";

	}

	@Override

	@RequestMapping(value = "/board/editForm.do", method = { RequestMethod.GET, RequestMethod.POST })

	public String editForm(HttpServletRequest request, @RequestParam("board_idx") int board_idx,
			@RequestParam("mode") String mode, Model model) throws Exception {

		ArticleVO avo = new ArticleVO();

		avo = boardService.viewArticle(board_idx);

		model.addAttribute("boardContent", avo);

		model.addAttribute("mode", mode);

		model.addAttribute("articleVO", new ArticleVO());

		return "/board/boardForm";

	}

	@Override

	@RequestMapping(value = "/board/deleteBoard.do", method = { RequestMethod.GET, RequestMethod.POST })

	public String deleteBoard(HttpServletRequest request, @RequestParam("board_idx") int board_idx, Model model,
			RedirectAttributes rttr) throws Exception {

		boardService.removeArticle(board_idx);

		return "redirect:/board/listArticles.do";

	}
}