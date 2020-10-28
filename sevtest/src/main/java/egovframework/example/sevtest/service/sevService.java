package egovframework.example.sevtest.service;

import java.util.List;

import egovframework.example.sevtest.sevVO;

public interface sevService {
	//로그인
	public sevVO UserLogin(sevVO vo)throws Exception; //아이디비밀번호확인
	public void LoginDate(sevVO vo)throws Exception;//로그인한날짜입력
	public sevVO userFailInfo(sevVO vo)throws Exception;//아이디확인
	public void UserFailCountUpdate(sevVO vo)throws Exception; //카운트증가
	public void UserLock(sevVO vo)throws Exception;//계정잠금 
	//회원가입
	public int idcount(sevVO vo)throws Exception;
	public boolean joinInsert(sevVO vo)throws Exception;
	//사용자관리
	public List<sevVO> sevList(sevVO vo)throws Exception;

	public boolean sevInsrert(sevVO vo)throws Exception;
	
	public sevVO sevSelect(sevVO vo)throws Exception;

	public boolean sevUpdate(sevVO vo)throws Exception;
	
	public boolean sevDelete(sevVO vo)throws Exception;
	//개인정보변경 
	public boolean userSettingUpdate(sevVO vo)throws Exception;
}
