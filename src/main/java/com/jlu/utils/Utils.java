package com.jlu.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * ClassName: Utils <br/>
 * Function: 通用工具类. <br/>
 * date: 2018年3月8日 上午11:17:35 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class Utils {

	/**
	 * 
	 * 私有构造函数：Utils.
	 *
	 */
	private Utils() {
	}

	/**
	 * 
	 * checkEleName:(检验元素名称). <br/>
	 * 
	 * @author liboqiang
	 * @param eleName
	 * @return
	 * @since JDK 1.6
	 */
	public static boolean checkEleName(String eleName) {
		return isMatch("^[A-Z][a-z]{0,2}$", eleName);
	}

	/**
	 * 匹配正则表达式，并提取匹配内容（复数个）
	 * 
	 * @param reg正则表达式
	 * @param str要匹配的字符串
	 * @param num要提取的组
	 * @return：提取到的内容
	 */
	public static List<String> matchs(String reg, String str, int num) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		List<String> res = new ArrayList<String>();
		while (matcher.find()) {
			res.add(matcher.group(num));
		}
		return res;
	}

	/**
	 * 匹配正则表达式，并提取匹配内容（复数个）
	 * 
	 * @param reg正则表达式
	 * @param str要匹配的字符串
	 * @return：提取到的内容
	 */
	public static List<String> matchs(String reg, String str) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		List<String> res = new ArrayList<String>();
		while (matcher.find()) {
			for (int i = 0; i < matcher.groupCount() + 1; i++) {
				res.add(matcher.group(i));
			}
		}
		return res;
	}

	/**
	 * 匹配正则表达式，并提取匹配内容（单个）
	 * 
	 * @param reg正则表达式
	 * @param str要匹配的字符串
	 * @param num要提取的组
	 * @return：提取到的内容
	 */
	public static String match(String reg, String str, int num) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		List<String> res = new ArrayList<String>();
		while (matcher.find()) {
			res.add(matcher.group(num));
		}
		if (res.size() == 0) {
			return "";
		}
		return res.get(0);
	}

	/**
	 * 匹配正则表达式，返回布尔类型
	 * 
	 * @param reg正则表达式
	 * @param str要匹配的字符串
	 * @return 是否匹配到
	 */
	public static boolean isMatch(String reg, String str) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: java2json
	 * @Description: Java对象转Json
	 * @param obj
	 * @return
	 */
	public static String java2json(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 
	 * @Title: json2Java
	 * @Description: Json对象转Java对象
	 * @param json
	 * @return
	 */
	public static Object json2Java(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Object javaObj = new Object();
		try {
			javaObj = mapper.readValue(json, Object.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return javaObj;
	}

	/**
	 * 
	 * base64Encode:(Base64加密). <br/>
	 * 
	 * @author liboqiang
	 * @param str
	 * @return
	 * @since JDK 1.6
	 */
	public static String base64Encode(String str) {
		try {
			return Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * base64Decode:(base64解码). <br/>
	 * 
	 * @author liboqiang
	 * @param str
	 * @return
	 * @since JDK 1.6
	 */
	public static String base64Decode(String str) {
		try {
			byte[] bytes = Base64.getDecoder().decode(str);
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * clone:(对象复制). <br/>
	 * 
	 * @author liboqiang
	 * @param obj
	 * @return
	 * @since JDK 1.6
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		T cloneObj = null;
		try {
			// 写入字节流
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream obs = new ObjectOutputStream(out);
			obs.writeObject(obj);
			obs.close();

			// 分配内存，写入原始对象，生成新对象
			ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(ios);
			// 返回生成的新对象
			cloneObj = (T) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cloneObj;
	}

	/**
	 * 
	 * genId:(生成Id). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	public static String genId() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
}
