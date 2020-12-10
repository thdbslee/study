package egovframework.example.sevtest.notice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
@Service("noticeService")
public class noticeServiceImpl extends EgovAbstractServiceImpl implements  noticeService {
	 @Resource(name="noticeDAO")
	 noticeDAO noticeDAO;

	@Override
	public boolean noticeInsert(noticeVO vo) throws Exception {
		System.out.println("Service");
		return noticeDAO.noticeInsert(vo);
	}

	@Override
	public List<noticeVO> noticeList(noticeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.noticeList(vo);
	}
	@Override
	public noticeVO noticeSelect(noticeVO vo)throws Exception{
		return noticeDAO.noticeSelect(vo);
	}
}
