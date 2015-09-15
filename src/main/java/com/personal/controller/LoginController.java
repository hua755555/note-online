package com.personal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.model.UserAccount;
import com.personal.service.UserAccountService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserAccountService userAccountService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("login/login");
	}
	
	@RequestMapping(value="/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response, 
			UserAccount user, ModelMap modelMap){
		try {
			user = userAccountService.doLogin(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user != null) {
			modelMap.put("user", user);
			return new ModelAndView("index");
		}
		return new ModelAndView("/login/login");
	}

	
}
