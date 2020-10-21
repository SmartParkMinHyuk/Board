package project.pc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.common.config.MsgConstants;
import project.common.config.ServiceConfig;
import project.common.controller.CommonController;
import project.common.exception.BizException;
import project.pc.service.LoginService;

@Controller
@RequestMapping("/pc/login/")
public class LoginController extends CommonController 
{
	@Autowired ServiceConfig serviceConfig;
	@Autowired LoginService  service;
	
	@RequestMapping("login")	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws BizException 
	{
		return new ModelAndView("/pc/login/login");
	}

	@RequestMapping("submit")
	public ModelAndView submit(HttpServletRequest request, HttpServletResponse response) throws BizException 
	{
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");

		try
		{
			HttpSession session = request.getSession(true);
			Object USER_ID = session.getAttribute("user_id");

			ModelAndView mav = new ModelAndView();
			//session check
			if (USER_ID == null || USER_ID == "")
			{
				String nickname = service.getUserNickname(user_id, user_pwd);
				//아이디가 없으면 login page 호출
				if(nickname == null)
				{
					mav.setViewName("/pc/login/login");
					mav.addObject("session", "nomember");
				}
				else
				{
					//회원 확인후 세션 부여
					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_NICKNAME", nickname);
					mav.setViewName("redirect:/pc/board/sessiontest");
				}
			}
			
			return mav;
		} 
		catch(Exception e) 
		{
			throw new BizException(MsgConstants.LOGIN_SYSTEM, MsgConstants.LOGIN_ERROR + "/" + e.getMessage());
		}
	}

	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws BizException 
	{
		try
		{
			request.getSession().setAttribute("USER_ID", null);
			request.getSession().invalidate();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/pc/login/session");
			mav.addObject("session", "logout");
			return mav;
		} 
		catch(Exception e) 
		{
			throw new BizException(MsgConstants.LOGIN_SYSTEM, MsgConstants.LOGOUT_ERROR + "/" + e.getMessage());
		}
	}

	@RequestMapping("sessionclose")
	public ModelAndView sessionclose(HttpServletRequest request, HttpServletResponse response) throws BizException 
	{
		try
		{
			request.getSession().setAttribute("USER_ID", null);
			request.getSession().invalidate();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/pc/login/session");
			mav.addObject("session", "sessionclose");
			return mav;
		} 
		catch(Exception e) 
		{
			throw new BizException(MsgConstants.LOGIN_SYSTEM, MsgConstants.SESSIONCLOSE_ERROR + "/" + e.getMessage());
		}
	}
}