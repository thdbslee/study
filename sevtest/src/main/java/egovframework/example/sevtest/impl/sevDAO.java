package egovframework.example.sevtest.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sevtest.sevVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("sevDAO")
public class sevDAO  extends EgovAbstractDAO{

	public List<sevVO> sevList(sevVO vo) throws Exception {
		// TODO Auto-generated method stub
		return (List<sevVO>) list("sevDAO.sevList",vo);
	}

	public boolean sevInsert(sevVO vo) throws Exception{
		boolean bol = false;
		bol = update("sevDAO.sevInsert",vo) > 0 ? true : false;
		System.out.println("DAO BOL ==>"+bol);
		return bol;
	}
	public sevVO sevSelect(sevVO vo)throws Exception{
		return (sevVO) select("sevDAO.sevSelect",vo);
	}
	public boolean sevUpdate(sevVO vo)throws Exception{
		boolean bol = false;
		bol = update("sevDAO.sevUpdate",vo) > 0 ? true : false;
		return bol;
	}
	public boolean sevDelete(sevVO vo)throws Exception{
		boolean bol = false;
		bol = update("sevDAO.sevDelete",vo) > 0 ? true : false;
		return bol;
	}
}
