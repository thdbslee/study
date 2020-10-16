package egovframework.example.sevtest.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sevtest.sevVO;
import egovframework.example.sevtest.service.sevService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
@Service("sevService")
public class sevServiceImpl extends EgovAbstractServiceImpl implements sevService {

	@Resource(name="sevDAO")
	private sevDAO sevDAO;

	@Override
	public List<sevVO> sevList(sevVO vo) throws Exception {
		
		return sevDAO.sevList(vo);
	}

	@Override
	public boolean sevInsrert(sevVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sevDAO.sevInsert(vo);
	}
	public sevVO sevSelect(sevVO vo)throws Exception{
		return sevDAO.sevSelect(vo);
	}
	
	public boolean sevUpdate(sevVO vo)throws Exception{
		return sevDAO.sevUpdate(vo);
	}
	@Override
	public boolean sevDelete(sevVO vo)throws Exception{
		return sevDAO.sevDelete(vo);
	}
}
