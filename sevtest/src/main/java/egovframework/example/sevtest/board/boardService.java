package egovframework.example.sevtest.board;

import java.util.List;

public interface boardService {
	//게시판
	public List<boardVO> boardList(boardVO vo)throws Exception;
	public boardVO boardSelect(boardVO vo) throws Exception;
	public boolean boardInsert(boardVO vo)throws Exception;
	public boolean boardDelete(boardVO vo)throws Exception;
	//댓글
	public List<commentVO> commentList(commentVO cmvo)throws Exception;
	public boolean commentInsert(commentVO cmvo)throws Exception;
}
