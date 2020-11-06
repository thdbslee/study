package egovframework.example.sevtest.level;

import java.util.List;

import egovframework.example.sevtest.sevVO;

public interface levelService {
	public List<levelVO> levelList(levelVO vo)throws Exception;
	public boolean levelInsert(levelVO vo) throws Exception;
	
}
