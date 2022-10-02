package com.java.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminAccountController {
	@RequestMapping("/admin/account")
	public String account() {
		return "/admin/account/account";
	}
	@RequestMapping("/admin/account-add")
	public String accountadd() {
		return "/admin/account/add-accounts";
	}

}
