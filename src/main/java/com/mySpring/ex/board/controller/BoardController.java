package com.mySpring.ex.board.controller;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

 

import com.mySpring.ex.board.domain.CommentVO;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.member.vo.MemberVO;

 

 

public interface BoardController {

   

   public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;

   public ModelAndView boardForm(@ModelAttribute("member") MemberVO member, @ModelAttribute("articleVO") ArticleVO articleVO,Model model, RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) throws Exception;

   public String saveBoard(@ModelAttribute("BoardVO")ArticleVO articleVO, @RequestParam("mode") String mode, @RequestParam("board_idx") int board_idx, HttpServletRequest req, @RequestParam("file") MultipartFile file, RedirectAttributes rttr) throws Exception;

   public String editForm(HttpServletRequest request, @RequestParam("board_idx") int board_idx, @RequestParam("mode") String mode, Model model) throws Exception;

   public String deleteBoard(HttpServletRequest request, @RequestParam("board_idx") int board_idx, Model model, RedirectAttributes rttr) throws Exception;

  

   public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest,HttpServletResponse response) throws Exception;

   

   public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO,

                                 HttpServletRequest request, HttpServletResponse response) throws Exception;

   //public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,  HttpServletResponse response) throws Exception;

   public ResponseEntity  removeArticle(@RequestParam("articleNO") int articleNO,

                              HttpServletRequest request, HttpServletResponse response) throws Exception;

   

   

   /*comment*/

   public ResponseEntity ajax_commentList(@RequestParam(value="board_idx")int board_idx,  HttpServletRequest request) throws Exception;

   public String ajax_addComment(@RequestParam(value="mem_id")String mem_id, @RequestParam(value="board_idx")int board_idx,@RequestParam(value="comment")String comment, HttpServletRequest request) throws Exception;

   public String ajax_commentUpdate(@RequestParam(value="comment_idx")int comment_idx, @RequestParam(value="comment")String comment, HttpServletRequest request) throws Exception;

   public String ajax_commentDelete(@RequestParam(value="comment_idx")int comment_idx,  HttpServletRequest request) throws Exception;

 

}