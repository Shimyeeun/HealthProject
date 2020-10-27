package com.mySpring.ex.board.service;

import java.util.List;
import java.util.Map;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.board.vo.CommentVO;

public interface BoardService {
	public List<ArticleVO> listArticles() throws Exception;
	public int addNewArticle(Map articleMap) throws Exception;
	public ArticleVO viewArticle(int board_idx) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;

    // ´ñ±Û °³¼ö
    public int commentCount() throws Exception;
 
    // ´ñ±Û ¸ñ·Ï
    public List<CommentVO> commentList() throws Exception;
 
    // ´ñ±Û ÀÛ¼º
    public int commentInsert(CommentVO comment) throws Exception;
    
    // ´ñ±Û ¼öÁ¤
    public int commentUpdate(CommentVO comment) throws Exception;
 
    // ´ñ±Û »èÁ¦
    public int commentDelete(int cno) throws Exception;
}
