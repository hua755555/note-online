package com.personal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.model.UserAccountModel;
import com.personal.model.UserProfileModel;
import com.personal.service.UserAccountService;
import com.personal.service.UserProfileService;
import com.personal.util.exception.ServiceException;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserProfileService userProfileService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("login/login");
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView postLogin(HttpServletRequest request, HttpServletResponse response, 
			UserAccountModel user, ModelMap modelMap) throws IOException{
		try {
			user = userAccountService.doLogin(user);
			if (user != null) {
				modelMap.put("profile", userProfileService.queryModel(user.getUid()) );
				return new ModelAndView("index");
			}
			return new ModelAndView("/login/login");
		} catch (Exception e) {
			sendError(request, response, e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postRegist(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, UserAccountModel account) throws IOException {
		try {
			userProfileService.doRegist(account);
		} catch (ServiceException e) {
			sendError(request, response, e.getMessage());
		}
		return "register/email";
	}

}
