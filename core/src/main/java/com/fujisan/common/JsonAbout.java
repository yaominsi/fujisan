package com.fujisan.common;

import com.google.gson.Gson;
/**
 * jsonת��
 * @author siyaomin
 *
 */
public class JsonAbout {
	public static final String asString(Object obj) {
		Gson gson = new Gson();  
		return gson.toJson(obj);
	}
}
