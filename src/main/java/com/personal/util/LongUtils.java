package com.personal.util;

import java.util.List;

public class LongUtils {
	/**
	 * 禁止实例化
	 */
	private LongUtils() {
		
	}
	
	public static boolean isEmpty(Long arg) {
		if (arg == null || arg.longValue() <= 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmptyList(List<Long> args) {
		if (args == null || args.isEmpty()){
			return true;
		}
		return false;
	}
}
