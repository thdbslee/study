package egovframework.example.sevtest.notice;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
@Service("noticeService")
public class noticeServiceImpl extends EgovAbstractServiceImpl implements  noticeService {
	 @Resource(name="noticeDAO")
	 noticeDAO noticeDAO;
}
