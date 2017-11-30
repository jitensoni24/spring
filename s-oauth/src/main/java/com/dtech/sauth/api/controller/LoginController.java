package com.dtech.sauth.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping(value = "/")
	public String app(ModelAndView mnv) throws Exception {
		return "index";
	}
}
