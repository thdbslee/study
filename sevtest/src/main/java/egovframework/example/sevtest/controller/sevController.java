package egovframework.example.sevtest.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sevtest.sevVO;
import egovframework.example.sevtest.service.*;

@Controller
public class sevController {
	@Resource(name="sevService")
	private sevService sevService;
	
	@RequestMapping(value="/mainTest.do")
	public String mainTest(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model) throws Exception {
		List<sevVO> list = sevService.sevList(vo);
		model.addAttribute("list", list);
		
		return "test/hello";
	}
}
