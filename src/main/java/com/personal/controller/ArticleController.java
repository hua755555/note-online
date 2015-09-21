package com.personal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personal.model.ArticleModel;
import com.personal.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController{
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ArticleModel postArticle(HttpServletRequest request,HttpServletResponse response,
			@RequestBody ArticleModel articleModel){
		
		articleModel.setUid(getUid(request));
		articleService.save(articleModel);
		
		return null;
		
	}
	
	
	
	

}
