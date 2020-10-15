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

}
