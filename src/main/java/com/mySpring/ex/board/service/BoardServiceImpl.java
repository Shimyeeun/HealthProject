package com.mySpring.ex.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.ex.board.dao.BoardDAO;
import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.board.domain.CommentVO;
import com.mySpring.ex.board.vo.ImageVO;


@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl  implements BoardService{
   @Autowired
   BoardDAO boardDAO;
   
   public List<ArticleVO> listArticles() throws Exception{
      List<ArticleVO> articlesList =  boardDAO.selectAllArticlesList();
        return articlesList;
   }

   
   //���� �̹��� �߰��ϱ�
   @Override
   public int addNewArticle(ArticleVO articleVO) throws Exception{
      return boardDAO.insertNewArticle(articleVO);
   }
   
    //���� �̹��� �߰��ϱ�
   /*
   @Override
   public int addNewArticle(Map articleMap) throws Exception{
      int articleNO = boardDAO.insertNewArticle(articleMap);
      articleMap.put("articleNO", articleNO);
      boardDAO.insertNewImage(articleMap);
      return articleNO;
   }
   */
   /*
   //���� ���� ���̱�
   @Override
   public Map viewArticle(int articleNO) throws Exception {
      Map articleMap = new HashMap();
      ArticleVO articleVO = boardDAO.selectArticle(articleNO);
      List<ImageVO> imageFileList = boardDAO.selectImageFileList(articleNO);
      articleMap.put("article", articleVO);
      articleMap.put("imageFileList", imageFileList);
      return articleMap;
   }
   */
   
   
    //���� ���� ���̱�
   @Override
   public ArticleVO viewArticle(int board_idx) throws Exception {
      ArticleVO articleVO = boardDAO.selectArticle(board_idx);
      return articleVO;
   }
   
   /*
   @Override
   
   public void modArticle(Map articleMap) throws Exception {
      boardDAO.updateArticle(articleMap);
   }
   */
   
   @Override
   public void removeArticle(int articleNO) throws Exception {
      boardDAO.deleteArticle(articleNO);
   }


   @Override
   public int commentCount() throws Exception {
      return boardDAO.commentCount();
   }


   @Override
   public List<CommentVO> commentList(int board_idx) throws Exception {
      List<CommentVO> commentList = boardDAO.commentList(board_idx);
      return commentList;
   }


   @Override
   public int commentInsert(CommentVO comment) throws Exception {
      
      return boardDAO.commentInsert(comment);
   }


   @Override
   public int commentUpdate(CommentVO comment) throws Exception {
	return boardDAO.commentUpdate(comment);

   }


   @Override
   public int commentDelete(int comment_idx) throws Exception {
      return boardDAO.commentDelete(comment_idx);
   }


   //article cnt increase
   @Override
   public void articleCntIncrease(int board_idx) throws Exception {
      boardDAO.articleCntIncrease(board_idx);
   }


@Override
public String getBoardContent(int board_idx) {
	
	return boardDAO.getBoardContent(board_idx);
}


@Override
public void modArticle(Map articleMap) throws Exception {
	// TODO Auto-generated method stub
	
}


@Override
public void updateBoard(ArticleVO articleVO) throws Exception {
	boardDAO.updateBoard(articleVO);
}



   
}