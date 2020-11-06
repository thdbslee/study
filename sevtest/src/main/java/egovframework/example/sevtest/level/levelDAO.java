package egovframework.example.sevtest.level;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
@Repository("levelDAO")
public class levelDAO extends EgovAbstractDAO {

	public boolean levelInsert(levelVO vo) throws Exception{
		boolean bol = false;
		bol = update("levelDAO.levelInsert",vo) > 0 ? true : false;
		return bol;
	}

	public List<levelVO> levelList(levelVO vo) throws Exception {
		
		return (List<levelVO>) list("levelDAO.levelList",vo);
	}

}
