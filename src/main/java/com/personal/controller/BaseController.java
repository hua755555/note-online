package com.personal.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.daoman.sso.SSOUtil;
import com.daoman.sso.SessionUser;
import com.google.common.collect.Maps;
import com.personal.config.AppConst;

public class BaseController {

	@Resource
	public MessageSource messageSource;

	/**
	 * 返回前端信息
	 * @param success
	 * @param arg
	 * @return
	 */
	public Map<String, Object> ajaxResult(Boolean success, Object arg){
		Map<String, Object> map = Maps.newHashMap();
		map.put("result", success);
		map.put("data", arg);
		return map;
	}

	/**
	 * 登出
	 * @param request
	 * @param response
	 */
	public void removeSession(HttpServletRequest request, HttpServletResponse response) {
		SSOUtil.removeSessionUser(request, response);
	}

	/**
	 * 从SSO获取登录用户信息
	 * @param request
	 * @return
	 */
	public SessionUser getSessionUser(HttpServletRequest request){
		return SSOUtil.getSessionUser(request);
	}

	/**
	 * 获取当前登录用户uid
	 * @param request
	 * @return
	 */
	public Long getUid(HttpServletRequest request){
		return SSOUtil.getSessionUser(request).getUid();
	}

	/**
	 * 返回错误到前端
	 * @param request
	 * @param response
	 * @param errorCode
	 * @throws IOException
	 */
	protected void sendError(HttpServletRequest request, HttpServletResponse response, String errorCode) throws IOException{
		String msg = messageSource.getMessage(errorCode, null, getLocale(request));

		response.addHeader("parox_error", URLEncoder.encode(msg, "utf-8"));

		response.sendError(518, errorCode);
	}

	/**
	 * 获取错误信息（国际化）
	 * @param request
	 * @param response
	 * @param errorCode
	 * @throws IOException
	 */
	protected String getErrorMsg(HttpServletRequest request, String errorCode) throws IOException{
		return messageSource.getMessage(errorCode, null, getLocale(request));
	}

	/**
	 * 国际化
	 * @param request
	 * @return
	 */
	private Locale getLocale(HttpServletRequest request){
		LocaleResolver localeResolver = RequestContextUtils	.getLocaleResolver(request);
		if (localeResolver != null) {
			return localeResolver.resolveLocale(request);
		}
		return null;
	}

	protected Map<String, String> getInitConfig(){
		Map<String, String> config = Maps.newHashMap();
//		config.put("avatarEndpoint", AppConst.CONFIG_PROPERTIES.get("oss.bucket.avatar.endpoint"));
		config.put("webRoot", AppConst.CONFIG_PROPERTIES.get("web.root"));
		config.put("chatServer", AppConst.CONFIG_PROPERTIES.get("chat.server"));
		config.put("debug", AppConst.getConfig("debug", "false"));
		return config;
	}
}