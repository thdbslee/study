package egovframework.example.sevtest.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "/test/hello";
	}
	@RequestMapping(value="/sev_manage.do")
	public String manageForm(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model)throws Exception{
		List<sevVO> list = sevService.sevList(vo);
		model.addAttribute("list", list);
		System.out.println("manage");
		return "/test/manage";
	}
	//직원등록폼
	@RequestMapping(value="/workInsert.do")
	public String workInsertForm(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model)throws Exception{
		System.out.println("직원등록FORM");
		return "/test/workInsert";
	}
	//직원등록
	@ResponseBody
	@Transactional
	@RequestMapping(value="/workInsert_ok.do", method=RequestMethod.POST,produces = "application/text; charset=utf8")
	public String workInsert(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model)throws Exception{
		System.out.println("직원등록INSERT");
		//System.out.println(ToStringBuilder.reflectionToString(vo));
		if(sevService.sevInsrert(vo)) {
			return "TRUE";
		}else {
			return "FALSE";
		}
	}
	//직원수정화면 
	@RequestMapping(value="/workEdit.do")
	public String workEditForm(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model)throws Exception{
		
		vo =sevService.sevSelect(vo); //inx체크하기 ? 
		model.addAttribute("editvo", vo);
		System.out.println("vo->"+vo.getINX());
		return"/test/workEdit";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value ="/workEdit_ok.do", method=RequestMethod.POST)
	public String workEditOk(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model)throws Exception{
		//vo.setInx(Integer.parseInt(request.getParameter("inx")));
		if(sevService.sevUpdate(vo)) {
			
			return "true";
		}else {
			return "false";
		}
		
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/workDelete.do",method=RequestMethod.POST)
	public String workDelete(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model)throws Exception{
		vo.setINXS(request.getParameterValues("inx_check"));
		System.out.println(ToStringBuilder.reflectionToString(vo));
		if(sevService.sevDelete(vo)) {
			return "true";
		}else {
			return "false";
		}
	}
}
