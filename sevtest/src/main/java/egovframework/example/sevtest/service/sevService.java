package egovframework.example.sevtest.service;

import java.util.List;

import egovframework.example.sevtest.sevVO;

public interface sevService {
	//로그인
	public sevVO UserLogin(sevVO vo)throws Exception; //아이디비밀번호확인
	public sevVO userFailInfo(sevVO vo)throws Exception;//아이디확인
	public void UserFailCountUpdate(sevVO vo)throws Exception; //카운트증가
	public void UserLock(sevVO vo)throws Exception;//계정잠금 
	
	//사용자관리
	public List<sevVO> sevList(sevVO vo)throws Exception;

	public boolean sevInsrert(sevVO vo)throws Exception;
	
	public sevVO sevSelect(sevVO vo)throws Exception;

	public boolean sevUpdate(sevVO vo)throws Exception;
	
	public boolean sevDelete(sevVO vo)throws Exception;
}
