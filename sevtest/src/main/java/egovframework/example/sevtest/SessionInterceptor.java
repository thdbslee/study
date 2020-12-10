package egovframework.example.sevtest;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 세션만료 시 로그인페이지로 이동한다.
	 * @return true(요청한 controller 호출), false(로그인페이지로 이동)
	 * @description 로그인, 로그인처리 페이지를 제외한 나머지 페이지에서 controller 호출 전에 세션유무를 파악하여 페이지 이동시킨다. 
	 * @exception Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception { 
		sevVO loginVo = (sevVO) request.getSession().getAttribute("Login");	// 로그인 사용자 세션정보
		String requestURI = request.getRequestURI(); // 요청 URI ex)/index.do
		/*System.out.println("URI->"+requestURI); 
		StringBuffer requestURL = request.getRequestURL(); ex)http://localhost:8080/index.do
		System.out.println("URL->"+requestURL);*/
		
		if (requestURI.indexOf("/login.do") > -1) { //indexof값이없으면 -1리턴인데 -1보다크면 true로가니까 컨트롤러로간다
			return true;
		} else if (requestURI.indexOf("/userLogin.do") > -1) {
			return true;
		} else {//값이없을경우 -1일경우 
			// 위의 예외페이지 외에는 세션값을 체크해서 있으면 그냥 페이지표시
			if (loginVo !=null && !loginVo.getID().isEmpty()) { //vo에값이있거나 id가있을경우는 true
				return true; 
			}
			else {
				// 정상적인 세션정보가 없으면 로그인페이지로 이동
				System.out.println("세션정보없음");
				ModelAndView modelAndView = new ModelAndView("redirect:/login.do");
				throw new ModelAndViewDefiningException(modelAndView);
			}
		}

	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model) throws Exception {
		String requestURI = request.getRequestURI();   
		sevVO loginVo = (sevVO) request.getSession().getAttribute("Login");	// 로그인 사용자 세션정보
		//System.out.println("requestURI :"+requestURI);
		if (requestURI.indexOf("/board.do") > -1) {
			if(loginVo.getLEVEL().equals("3")) {
				//Map<String, Object> rtnMap = new HashMap<String, Object>();
				//rtnMap.put("msgContent", "등업 후 자유게시판 사용가능");
				request.getRequestDispatcher("/levelList.do");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('자유게시판 등업후 사용가능 등업게시판 이용하세요'); location.href='/levelList.do';</script>");
				out.flush();
				throw new ModelAndViewDefiningException(new ModelAndView("redirect:/levelList.do"));
				
			}
		}
		//로그인정보 뷰단에 보냄
		if(loginVo !=null) {
			System.out.println("인터셉터loginVo::"+loginVo.getID());
			model.addObject("loginvo", loginVo);
		}
		
	}
	
}