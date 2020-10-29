package com.mySpring.ex.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mySpring.ex.board.domain.CommentVO;
import com.mySpring.ex.board.vo.ArticleVO;


public interface BoardController {
   
   public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;
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