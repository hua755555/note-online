package com.personal.config;

import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.personal.util.file.PropertiesUtil;

/**
 * @author mays
 * 
 */
@Component("appConst")
public class AppConst {

	public final static String SESSION_KEY = "sessionuserkey";

	/**
	 * 默认日期格式：yyyy-MM-dd HH:mm:ss
	 */
	public final static String DATE_FORMAT_DEFAULT="yyyy-MM-dd HH:mm:ss";
	/**
	 * 仅日期格式：yyyy-MM-dd
	 */
	public final static String DATE_FORMAT_DATE="yyyy-MM-dd";
	/**
	 * 仅时间格式：HH:mm:ss
	 */
	public final static String DATE_FORMAT_TIME="HH:mm:ss";

	public final static String LOGIN_REMEMBER_TOKEN = "_PLT";

	public static Map<String, String> CONFIG_PROPERTIES = null;

	//redis中的SHARE_LINK_KEY名称前缀
	public static final String REDIS_SHARE_LINK_KEY_PREFIX = "slink_";
	//cookie中的SHARE_LINK_KEY名称
	public static final String COOKIE_SHARE_LINK_KEY_PREFIX = "_pslk_";
	
	public static final String COOKIE_PATCHCA="_PCT"; 

	@PostConstruct
	public void init(){
		try {
			CONFIG_PROPERTIES = PropertiesUtil.classpathRead("config.properties", PropertiesUtil.CHARSET_UTF8);
		} catch (IOException e) {
			CONFIG_PROPERTIES = Maps.newHashMap();
		}
	}

	public static String getConfig(String key, String def){
		if(CONFIG_PROPERTIES==null){
			return def;
		}

		String v =CONFIG_PROPERTIES.get(key);
		if(Strings.isNullOrEmpty(v)){
			return def;
		}
		return v;
	}

	public static String getConfig(String key){
		return getConfig(key, null);
	}
	
	public enum INDEX{
		
	}
}