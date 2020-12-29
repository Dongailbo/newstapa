package com.kb.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kb.api.service.MasterService;
import com.kb.api.util.Common;
import com.kb.api.util.ProHashMap;

@RestController
public class MainRestController {
	
	@Inject MasterService masterService;
	
	@GetMapping("/api/v1/n1905")  
	public ResponseEntity<Map<String, Object>> n1905(HttpSession session) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();

		List<HashMap<String, Object>> list = null;
		list = (List<HashMap<String, Object>>) masterService.dataList("mapper.MainMapper", "n1905", null);
		
		map.put("data", list);
		
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		Common.returnPrint(Common.GmakeDynamicValueObject(entity));
		return entity; 
	}
	@GetMapping("/api/v1/n2002/rank/{year}")  
	public ResponseEntity<Map<String, Object>> rank(HttpSession session, @PathVariable String year) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("year", year);
		List<HashMap<String, Object>> list = null;
		list = (List<HashMap<String, Object>>) masterService.dataList("mapper.MainMapper", "n2002_rank", param  );
		
		map.put("data", list);
		
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		Common.returnPrint(Common.GmakeDynamicValueObject(entity));
		return entity; 
	}
	@GetMapping("/api/v1/n2002/select")  
	public ResponseEntity<Map<String, Object>> n2002_select(HttpSession session) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<HashMap<String, Object>> list = null;
		list = (List<HashMap<String, Object>>) masterService.dataList("mapper.MainMapper", "n2002_select", null);
		
		map.put("data", list);
		
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		Common.returnPrint(Common.GmakeDynamicValueObject(entity));
		return entity; 
	}
	@GetMapping("/api/v1/n2002/{seq}")  
	public ResponseEntity<Map<String, Object>> n2002_select(HttpSession session, @PathVariable String seq) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		HashMap<String, Object> read = null;
		read = ( HashMap<String, Object>) masterService.dataRead("mapper.MainMapper", "n2002_read", seq);
		
		List<HashMap<String, Object>> list = null;
		list = (List<HashMap<String, Object>>) masterService.dataList("mapper.MainMapper", "n2002_300", seq);
		
		map.put("data", read);
		map.put("list", list); 
		
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		Common.returnPrint(Common.GmakeDynamicValueObject(entity));
		return entity;  
	}
	@PostMapping("/api/v1/n2002/info")  
	public ResponseEntity<Map<String, Object>> n2002_select_info(HttpSession session, @RequestBody ProHashMap param) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		HashMap<String, Object> read = null;
		read = ( HashMap<String, Object>) masterService.dataRead("mapper.MainMapper", "t_congress_read", param);
		
		List<HashMap<String, Object>> list = null;
		list = (List<HashMap<String, Object>>) masterService.dataList("mapper.MainMapper", "t_congress_info_list", read);
		
		map.put("data", read);
		map.put("list", list);
		
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK); 
		Common.returnPrint(Common.GmakeDynamicValueObject(entity));
		return entity; 
	}
}
