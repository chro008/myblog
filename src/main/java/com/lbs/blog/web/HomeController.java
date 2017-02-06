package com.lbs.blog.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping(value = { "/", "/home", "/index" })
	public String homepage(Map<String, Object> model) {
		model.put("user", "liming");
		return "homepage";
	}

	@RequestMapping("/regist")
	public String regist() {
		return "regist";
	}

	@RequestMapping("/resetpwd")
	public String resetpwd() {
		return "resetpwd";
	}
}
