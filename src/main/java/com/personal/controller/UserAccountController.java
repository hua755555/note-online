package com.personal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.service.UserAccountService;

@Controller
@RequestMapping("/user")
public class UserAccountController {
	@Autowired
	public UserAccountService userService;

	@RequestMapping(value="/send", method = RequestMethod.GET)
	public Map<String, String> showUser() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		
		return map;
	}

}