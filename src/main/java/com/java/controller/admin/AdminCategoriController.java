package com.java.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminCategoriController {
	@RequestMapping ("/admin/categori-add")
	public String categori() {
		return "/admin/categori/categori";
	}
}
