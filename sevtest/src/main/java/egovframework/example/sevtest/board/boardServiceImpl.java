package egovframework.example.sevtest.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
@Service("boardService")
public class boardServiceImpl extends EgovAbstractServiceImpl implements boardService {
	@Resource(name="boardDAO")
	boardDAO boardDAO;
	//게시판
	@Override
	public List<boardVO> boardList(boardVO vo) throws Exception {	
		return boardDAO.boardList(vo);
	}
	@Override
	public boardVO boardSelect(boardVO vo)throws Exception{
		return boardDAO.boardSelect(vo);
	}
	//댓글
	@Override
	public List<commentVO> commentList(commentVO cmvo)throws Exception{
		return boardDAO.commentList(cmvo);
	}
	@Override
	public boolean commentInsert(commentVO cmvo)throws Exception{
		return boardDAO.commentInsert(cmvo);
	}
}