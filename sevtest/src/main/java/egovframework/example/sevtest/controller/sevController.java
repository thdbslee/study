package egovframework.example.sevtest.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import net.sf.json.JSONObject;
@Controller
public class sevController {
	@Resource(name="sevService")
	private sevService sevService;
	
	
	//로그인
	@RequestMapping(value="/login.do")
	public String login(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginVO = (sevVO)sess.getAttribute("Login");
		
		return"/test/login";
	}
	@RequestMapping(value="/index.do")
	public String index(HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginVo =(sevVO)sess.getAttribute("Login");
		System.out.println("indexof AUTH_CODE=>"+loginVo.getAUTH_CODE());
		if(loginVo.getAUTH_CODE().equals("9")) {//관리자모드일때
			return "redirect:/mainTest.do";
		}else {//일반사용자로그인할때
			return "redirect:/userMain.do";
		}
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/userLogin.do")
	public String userLogin(@ModelAttribute("vo")sevVO vo,@ModelAttribute("failVo")sevVO failVo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		JSONObject json = new JSONObject();
		vo = sevService.UserLogin(vo); //아이디비밀번호확인
		if(vo!=null) {//아이디비밀번호맞으면 
			//이미락걸린경우
			if(vo.getLOCK_YN().equals("Y")) {
				System.out.println("이미락걸린경우");
				json.put("resultCode", "LOCK");
			}else {
				System.out.println("로그인성공");
				sevService.LoginDate(vo); //로그인한날짜등록
				sess.setAttribute("Login", vo);
				json.put("resultCode", "Y");
			}
		}else {
			System.out.println("");
			String loginId = request.getParameter("ID");
			failVo.setID(loginId);
			failVo = sevService.userFailInfo(failVo);
			if(failVo !=null) {
				int failcount = failVo.getFAIL_COUNT();
				if(failcount < 5) {
					sevService.UserFailCountUpdate(failVo);
					json.put("resultCode", "N");
				}else {
					sevService.UserLock(failVo);
					json.put("resultCode","LOCK");
				}
			}
		}
			return json.toString();
			
	}
	//로그아웃
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession sess,HttpServletRequest request)throws Exception{
		System.out.println("로그아웃");
		sess.invalidate();
		return "redirect:/login.do";
	}
	//회원가입
	@RequestMapping(value="/join.do")
	public String joinForm(HttpServletRequest request,ModelMap model)throws Exception{
		return"/test/join";
	}
	//회원가입ok
	@ResponseBody
	@Transactional
	@RequestMapping(value="/join_ok.do")
	public String join_ok(HttpServletRequest request,ModelMap model,@ModelAttribute("vo")sevVO vo)throws Exception{
		//id중복체크
		int idcount = sevService.idcount(vo); //아이디갯수체크
		if(idcount==0) {
			if(sevService.joinInsert(vo)) { //아이디갯수0이면 회원가입가능
				return "true";
			}else {
				return "n";
			}
		}else {
			return "false";
		}
		
	}
	
	
	//사용자관리
	@RequestMapping(value="/mainTest.do")
	public String mainTest(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model,HttpSession sess) throws Exception {
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		if(loginvo.getAUTH_CODE().equals("9")) {
			System.out.println("AUTH_CODE->"+loginvo.getAUTH_CODE());
			model.addAttribute("login", loginvo); //jsp에 로그인한 이름 확인하기*/
			
			List<sevVO> list = sevService.sevList(vo);//작성자리스트 
			model.addAttribute("list", list);
			return "/test/hello";	
		}else {
			System.out.println("일반사용자는mainTestxxxxxxx");
			return "redirect:/index.do";
		}

	}
	//일반모드로로그인시
	@RequestMapping(value="/userMain.do")
	public String userMain(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model,HttpSession sess) throws Exception {
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		System.out.println("AUTH_CODE->"+loginvo.getAUTH_CODE());
		model.addAttribute("login", loginvo); //jsp에 로그인한 이름 확인하기
		
		List<sevVO> list = sevService.sevList(vo);//작성자리스트 
		model.addAttribute("list", list);
		return "/test/userMain";
	}
	@RequestMapping(value="/sev_manage.do")
	public String manageForm(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		if(loginvo.getAUTH_CODE().equals("9")) {
			List<sevVO> list = sevService.sevList(vo);
			model.addAttribute("list", list);
			System.out.println("manage");
			return "/test/manage";
		}else {
			return "redirect:/index.do";
		}
		
	}
	@RequestMapping(value="/user_List.do")
	public String userForm(@ModelAttribute("vo")sevVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		List<sevVO> list = sevService.sevList(vo);
		model.addAttribute("list", list);
		return "/test/userList";
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
		int idcount = sevService.idcount(vo);
		if(idcount ==0) {
			if(sevService.sevInsrert(vo)) {
				return "TRUE";
			}else {
				return "n";
			}
		}else {
			return "false";
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
	// 개인정보MyPage
	@RequestMapping(value="/setting.do")
	public String settingForm(HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		System.out.println("loginvo->"+loginvo);
		System.out.println(ToStringBuilder.reflectionToString(loginvo));
		return"/test/setting/settingForm";
	}
	//Mypage 비밀번호확인 후 변경홈페이지나오게
	@ResponseBody
	@Transactional
	@RequestMapping(value="/setting_passwd.do")
	public String settingpasswd(@ModelAttribute("vo")sevVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		vo = sevService.UserLogin(vo);
		if(vo!=null) {
			return "true";
		}else {
			return "false";
		}
	}
	@RequestMapping(value="/setting_edit_form.do")
	public String setEditForm(@ModelAttribute("vo")sevVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo",loginvo);
		return"/test/setting/setting";
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping(value="/setting_eidt.do")
	public String settingEdit(@ModelAttribute("vo")sevVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("vo", vo);
		System.out.println("변경전이름=>"+loginvo.getNAME());
		if(sevService.userSettingUpdate(vo)) {
			sess.setAttribute("Login", loginvo); //세션업데이트하기->로그아웃안해도 세션바뀜
			System.out.println("변경후이름=>"+loginvo.getNAME());
			return "true";
		}else {
			System.out.println("정보변경오류");
			return "false";
		}
		
	}
}
