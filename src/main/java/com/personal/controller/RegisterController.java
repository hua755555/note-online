package com.personal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personal.model.UserAccountModel;
import com.personal.model.UserProfileModel;
import com.personal.service.UserProfileService;
import com.personal.util.exception.ServiceException;

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController{

	@Autowired 
	private UserProfileService userProfileService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String postRegist(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, UserAccountModel account) throws IOException {
		try {
			UserProfileModel profile = userProfileService.doRegist(account);
			if(profile.getId() !=null && profile.getId().longValue() >0){
				return "login/dashbord";
			}
		} catch (ServiceException e) {
			sendError(request, response, e.getMessage());
		}
		return "register/index";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap out) {
		
		return "/register/index";
	}
}
