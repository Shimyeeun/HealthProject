package com.mySpring.ex.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.ex.board.vo.ArticleVO;
import com.mySpring.ex.board.vo.CommentVO;
import com.mySpring.ex.board.vo.ImageVO;


@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllArticlesList() throws DataAccessException {
		List<ArticleVO> articlesList  = sqlSession.selectList("mapper.board.selectAllArticlesList");
		System.out.println("id: " + articlesList.get(0).getMem_id());
		System.out.println("board_idx: " + articlesList.get(0).getBoard_idx());
		return articlesList;
	}

	
	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		int articleNO = selectNewArticleNO();
		articleMap.put("articleNO", articleNO);
		sqlSession.insert("mapper.board.insertNewArticle",articleMap);
		return articleNO;
	}
    
	//���� ���� ���ε�
	/*
	@Override
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		int articleNO = (Integer)articleMap.get("articleNO");
		int imageFileNO = selectNewImageFileNO();
		for(ImageVO imageVO : imageFileList){
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setArticleNO(articleNO);
		}
		sqlSession.insert("mapper.board.insertNewImage",imageFileList);
	}
	
   */
	
	@Override
	public ArticleVO selectArticle(int board_idx) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectArticle", board_idx);
	}

	@Override
	public void updateArticle(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateArticle", articleMap);
	}

	@Override
	public void deleteArticle(int articleNO) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteArticle", articleNO);
		
	}
	
	@Override
	public List selectImageFileList(int articleNO) throws DataAccessException {
		List<ImageVO> imageFileList = null;
		imageFileList = sqlSession.selectList("mapper.board.selectImageFileList",articleNO);
		return imageFileList;
	}
	
	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewArticleNO");
	}
	
	private int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewImageFileNO");
	}


	@Override
	public int commentCount() throws DataAccessException {
		return sqlSession.selectOne("mapper.comment.selectCommentCount");
	}


	@Override
	public List<CommentVO> commentList() throws DataAccessException {
		List<CommentVO> commentList = sqlSession.selectList("mapper.comment.selectCommentList");
		return commentList;
	}


	@Override
	public int commentInsert(CommentVO comment) throws DataAccessException {
		
		return 0;
	}


	@Override
	public int commentUpdate(CommentVO comment) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int commentDelete(int cno) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
