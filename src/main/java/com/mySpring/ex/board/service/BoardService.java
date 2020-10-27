package com.mySpring.ex.board.service;

import java.util.List;
import java.util.Map;

import com.mySpring.ex.board.vo.ArticleVO;

public interface BoardService {
	public List<ArticleVO> listArticles() throws Exception;
	public int addNewArticle(Map movieMap) throws Exception;
	public ArticleVO viewArticle(int exercise_idx) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;
	public void modArticle(Map movieMap) throws Exception;
	public void removeArticle(int movieNO) throws Exception;
}
