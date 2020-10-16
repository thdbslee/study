package egovframework.example.sevtest.service;

import java.util.List;

import egovframework.example.sevtest.sevVO;

public interface sevService {


	public List<sevVO> sevList(sevVO vo)throws Exception;

	public boolean sevInsrert(sevVO vo)throws Exception;
	
	public sevVO sevSelect(sevVO vo)throws Exception;

	public boolean sevUpdate(sevVO vo)throws Exception;
	
	public boolean sevDelete(sevVO vo)throws Exception;
}
