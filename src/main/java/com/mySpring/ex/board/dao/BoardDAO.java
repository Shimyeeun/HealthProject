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
	
    // ��� ����
    public int commentCount() throws DataAccessException;
 
    // ��� ���
    public List<CommentVO> commentList() throws DataAccessException;
 
    // ��� �ۼ�
    public int commentInsert(CommentVO comment) throws DataAccessException;
    
    // ��� ����
    public int commentUpdate(CommentVO comment) throws DataAccessException;
 
    // ��� ����
    public int commentDelete(int cno) throws DataAccessException;
	
}
