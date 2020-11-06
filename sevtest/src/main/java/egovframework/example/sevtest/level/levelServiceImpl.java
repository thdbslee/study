package egovframework.example.sevtest.level;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
@Service("levelService")
public class levelServiceImpl extends EgovAbstractServiceImpl implements levelService {
	@Resource(name="levelDAO")
	levelDAO levelDAO;
	
	public List<levelVO> levelList(levelVO vo)throws Exception{
		return levelDAO.levelList(vo);
	}
	@Override
	public boolean levelInsert(levelVO vo) throws Exception {
	
		return levelDAO.levelInsert(vo);
	}

}
