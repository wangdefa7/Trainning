package com.util;

import com.alibaba.fastjson.JSONObject;
import com.domain.Location;
import com.domain.Photo;
import com.domain.User;


public class ToBean {
	/**
	 *
	 * @param str
	 * @return
	 */
	public static Location stringtobean_Location(String str) {
		JSONObject jsonObject = JSONObject.parseObject(str);
		Location strbean=JSONObject.toJavaObject(jsonObject,Location.class);
		return strbean;
		}
	
	public static User stringtobean_User(String str) {
		JSONObject jsonObject = JSONObject.parseObject(str);
		User strbean=JSONObject.toJavaObject(jsonObject,User.class);
		return strbean;
		}
	public static Photo stringtobean_Photo(String str) {
		JSONObject jsonObject = JSONObject.parseObject(str);
		Photo strbean=JSONObject.toJavaObject(jsonObject,Photo.class);
		return strbean;
		}
	


}
