package com.mySpring.ex.board.service;

import java.util.List;
import java.util.Map;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.board.domain.CommentVO;

public interface BoardService {
   public List<ArticleVO> listArticles() throws Exception;
   public int addNewArticle(Map movieMap) throws Exception;
   public ArticleVO viewArticle(int exercise_idx) throws Exception;
   //public Map viewArticle(int articleNO) throws Exception;

   public void modArticle(Map articleMap) throws Exception;
   public void removeArticle(int articleNO) throws Exception;
   
    // 占쏙옙占  占쏙옙占쏙옙
    public int commentCount() throws Exception;
 
    // 占쏙옙占  占쏙옙占 
    public List<CommentVO> commentList(int board_idx) throws Exception;
 
    // 占쏙옙占  占쌜쇽옙
    public int commentInsert(CommentVO comment) throws Exception;
    
    // comment update
    public int commentUpdate(CommentVO comment) throws Exception;
 
    // 占쏙옙占  占쏙옙占쏙옙
    public int commentDelete(int comment_idx) throws Exception;
    
    // article cnt increase
    public void articleCntIncrease(int board_idx) throws Exception;
}