package com.kb.api.controller;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kb.api.service.MasterService;

@Controller
public class MainController {  
	
	@Inject MasterService masterService;
	
	@GetMapping("/n1905")
	public String test(Model model, HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		session.invalidate();
		return "layout/n1905";
	}
	
	@GetMapping("/n2002")
	public String test2(Model model, HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		session.invalidate();
		return "layout/n2002";
	}
}
