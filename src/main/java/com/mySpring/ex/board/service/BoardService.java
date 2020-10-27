package com.mySpring.ex.board.service;

import java.util.List;
import java.util.Map;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.board.vo.CommentVO;

public interface BoardService {
	public List<ArticleVO> listArticles() throws Exception;
	public int addNewArticle(Map movieMap) throws Exception;
	public ArticleVO viewArticle(int exercise_idx) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;

	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;

    // ��� ����
    public int commentCount() throws Exception;
 
    // ��� ���
    public List<CommentVO> commentList() throws Exception;
 
    // ��� �ۼ�
    public int commentInsert(CommentVO comment) throws Exception;
    
    // ��� ����
    public int commentUpdate(CommentVO comment) throws Exception;
 
    // ��� ����
    public int commentDelete(int cno) throws Exception;
}
