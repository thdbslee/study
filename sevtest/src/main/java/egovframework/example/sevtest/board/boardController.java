package egovframework.example.sevtest.board;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.sevtest.sevVO;
import egovframework.example.sevtest.service.*;
@Controller
public class boardController {
	@Resource(name="sevService")
	sevService sevService;
	@Resource(name="boardService")
	boardService boardService;
	
	@RequestMapping(value="/board.do", produces="application/text; charset=utf8")
	public String boardForm(@ModelAttribute("vo")boardVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		model.addAttribute("login", loginvo);//아이디불러오기위해 
		List<boardVO> list = boardService.boardList(vo);
		model.addAttribute("list", list);//리스트불러오기위해 
		
		return"/test/board/board";
	}
	@RequestMapping(value="/boardInsert.do")
	public String boardInsertForm(@ModelAttribute("vo")boardVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		model.addAttribute("login", loginvo);
		return"/test/board/boardInsert";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/boardInsert_ok.do")
	public String boardInsert(@ModelAttribute("vo")boardVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		//로그인아이디나타내기 
		model.addAttribute("login", loginvo);
		System.out.println("boardInsert->"+vo.getTITLE());
		if(boardService.boardInsert(vo)) {
			return"true";
		}else {
			return"false";
		}
	}
	@ResponseBody
	@Transactional
	@RequestMapping("/boardDelete")
	public String boardDelete(@ModelAttribute("vo")boardVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
			
		vo.setINXS(request.getParameterValues("INX_CHK"));
		System.out.println(ToStringBuilder.reflectionToString(vo));
		if(loginvo.getAUTH_CODE().equals("9")) {
			if(boardService.boardDelete(vo)) {
				return "true";
			}else {
				
				return "false";
			}
		}else {
			System.out.println("일반사용자");
			return "nn";
		}
	}
	/** 댓글달기
	 * @param vo
	 * @param cmvo
	 * @param sess
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/boardDetail.do", produces="application/text; charset=utf8")
	public String boardDetail(@ModelAttribute("vo")boardVO vo,@ModelAttribute("cmvo")commentVO cmvo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("sevvo", loginvo);
		//게시판선택
		vo = boardService.boardSelect(vo);
		model.addAttribute("boardvo", vo);
		
		//댓글리스트불러오기
		List<commentVO> list = boardService.commentList(cmvo);
		
		model.addAttribute("cmlist", list);
		
		return "/test/board/boardDetail";
	}
	//댓글등록
	@ResponseBody
	@Transactional
	@RequestMapping(value="/comment_ok.do", produces="application/text; charset=utf8")
	public String commentInsert(@ModelAttribute("cmvo")commentVO cmvo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo =(sevVO)sess.getAttribute("Login");
		if(boardService.commentInsert(cmvo)) {
			return "true";
		}else {
			return "false";
		}
	}
	
	
}
