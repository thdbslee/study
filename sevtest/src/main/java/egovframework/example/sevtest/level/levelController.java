package egovframework.example.sevtest.level;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.sevtest.sevVO;
import egovframework.example.sevtest.service.sevService;

@Controller
public class levelController {
	@Resource(name="levelService")
	levelService levelService;
	@Resource(name="sevService")
	sevService sevService;
	@RequestMapping(value="/levelList.do")
	public String levelForm(@ModelAttribute("vo")levelVO vo,@ModelAttribute("sevvo")sevVO sevvo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		List<levelVO> list = levelService.levelList(vo);
		model.addAttribute("list", list);
		
		
		return "/test/level/level";
	}
	
	@RequestMapping(value="/level_insert.do")
	public String levelInsert(@ModelAttribute("vo")levelVO vo,@ModelAttribute("sevvo")sevVO sevvo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		
		return "/test/level/level_insert";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/level_insert_ok.do")
	public String levInsert(@ModelAttribute("vo")levelVO vo,@ModelAttribute("sevvo")sevVO sevvo,@ModelAttribute("svo")sevVO svo,
			HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginvo =(sevVO)sess.getAttribute("Login");
		if(levelService.levelInsert(vo)) {
			sevService.sevUpdateLev(svo); //등록게시물건수 증가시키기  --받아온값을 가지고 update 
			svo = sevService.sevLevList(svo); //사용자 게시물건수 불러오기
			int count = svo.getLEV_COUNT(); //게시물건수몇개인지 
			System.out.println("count-->"+count);
				if(count ==3) {
				//level staff로 upgrade시키기 
				sevService.sevLevelUpgrade(sevvo);
				sevvo = sevService.sevLevList(sevvo); //사용자 게시물건수 불러오기 
				System.out.println("sevvo레벨 =>"+sevvo.getLEVEL());
				loginvo.setLEVEL(sevvo.getLEVEL());
				System.out.println("로그인레벨=>"+loginvo.getLEVEL());
				sess.setAttribute("Login", loginvo); //세션업데이트하기
	
				return"upgrade";
		
				}else {
					System.out.println("등록");
					return "true";
				}
		}else {
			return "false";
		}
	}
}
