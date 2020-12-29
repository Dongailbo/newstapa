package com.kb.api.util;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * @version : java1.8
 * @author : ohs
 * @date : 2018. 8. 8.
 * @class :
 * @message : API 서버 공통 소스
 * @constructors :
 * @method :
 */
public class Common {
	static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	public static void returnPrint(String str){
		
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(str);
		str = gson.toJson(je);
		
		System.out.println("--------------------      Response Param     ---------------------------");
		System.out.println(str);
		System.out.println("------------------------------------------------------------------------");
	}
	public static String GmakeDynamicValueObject(ResponseEntity<Map<String, Object>> entity){
		String ss = "";
		ss += gson.toJson(entity);
		return ss;
	}
}
