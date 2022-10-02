package com.java.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdminAuthenticateController {
	@RequestMapping ("/admin/authenticate")
	public String categori() {
		return "/admin/authenticate/phanquyen";
	}

}
