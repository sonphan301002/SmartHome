package com.java.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminCungcapControlelr {
	@RequestMapping("/admin/NCC")
	public String product() {
		return "/admin/cungcap/NCC";
	}

}
