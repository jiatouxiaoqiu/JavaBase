package cn.ebing.dog.api.utils;

import java.util.UUID;

public class CommonUtil {
	public static String create32Key() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
