package com.mySpring.ex.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.board.vo.CommentVO;


public interface BoardDAO {
	public List selectAllArticlesList() throws DataAccessException;
	public int insertNewArticle(Map articleMap) throws DataAccessException;
	//public void insertNewImage(Map articleMap) throws DataAccessException;
	
	public ArticleVO selectArticle(int articleNO) throws DataAccessException;
	public void updateArticle(Map articleMap) throws DataAccessException;
	public void deleteArticle(int articleNO) throws DataAccessException;
	public List selectImageFileList(int articleNO) throws DataAccessException;
	
    // ´ñ±Û °³¼ö
    public int commentCount() throws DataAccessException;
 
    // ´ñ±Û ¸ñ·Ï
    public List<CommentVO> commentList() throws DataAccessException;
 
    // ´ñ±Û ÀÛ¼º
    public int commentInsert(CommentVO comment) throws DataAccessException;
    
    // ´ñ±Û ¼öÁ¤
    public int commentUpdate(CommentVO comment) throws DataAccessException;
 
    // ´ñ±Û »èÁ¦
    public int commentDelete(int cno) throws DataAccessException;
	
}
