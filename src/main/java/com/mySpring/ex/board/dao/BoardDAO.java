package com.mySpring.ex.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.board.domain.CommentVO;


public interface BoardDAO {
   public List selectAllArticlesList() throws DataAccessException;
   public int insertNewArticle(ArticleVO articleVO) throws DataAccessException;
   //public void insertNewImage(Map articleMap) throws DataAccessException;
   public void updateBoard(ArticleVO articleVO) throws DataAccessException;
   public ArticleVO selectArticle(int board_idx) throws DataAccessException;
   public String getBoardContent(int board_idx) throws DataAccessException;
   //public void updateArticle(Map articleMap) throws DataAccessException;
   public void deleteArticle(int articleNO) throws DataAccessException;
   public List selectImageFileList(int articleNO) throws DataAccessException;
   
    // ´ñ±Û °³¼ö
    public int commentCount() throws DataAccessException;
 
    // ´ñ±Û ¸ñ·Ï
    public List<CommentVO> commentList(int board_idx) throws DataAccessException;
 
    // ´ñ±Û ÀÛ¼º
    public int commentInsert(CommentVO comment) throws DataAccessException;
    
    // ´ñ±Û ¼öÁ¤
    public int commentUpdate(CommentVO comment) throws DataAccessException;
 
    // ´ñ±Û »èÁ¦
    public int commentDelete(int comment_idx) throws DataAccessException;
    
    //article cnt increase
    public void articleCntIncrease(int board_idx) throws DataAccessException;
   
}