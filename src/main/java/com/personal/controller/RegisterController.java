package com.personal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personal.model.UserAccount;
import com.personal.service.UserAccountService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired 
	private UserAccountService userAccountService;
	
	@RequestMapping(value = "/doRegister/", method = RequestMethod.POST)
	public String doRegister(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, UserAccount account) {
		if (account.getEmail() != null && account.getPassword() != null
				&& account.getName() != null) {
			return null;
		}
		account.setStatus(UserAccount.STATUS_NOT_ACTIVATED);
		userAccountService.insert(account);
		return "register/email";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap out) {
		
		return "/register/index";
	}
}
