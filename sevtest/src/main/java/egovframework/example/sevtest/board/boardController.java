package egovframework.example.sevtest.board;

import java.util.List;

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
		model.addAttribute("login", loginvo);
		List<boardVO> list = boardService.boardList(vo);
		model.addAttribute("list", list);
		return"/test/board/board";
	}
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
	/*@RequestMapping(value="/boardInsert.do")
	public String boardInsert(@ModelAttribute("vo")boardVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		model.addAttribute("sevvo", loginvo);
		if(boardService.boardInsert(vo)) {
			return "true";
		}else {
			return "false";
		}
	}*/
	
}
