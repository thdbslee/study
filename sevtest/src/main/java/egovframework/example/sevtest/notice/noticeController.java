package egovframework.example.sevtest.notice;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller 
public class noticeController {
	@Resource(name="noticeService")
	noticeService noticeService; 
	
	
}
