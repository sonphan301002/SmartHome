package com.java.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class DirectoryController {
	@RequestMapping("/reviewap") //review
	public String Reviewap() {
		return "/directory/reviewap";
	}
	
	@RequestMapping("/reviewvac")
	public String Reviewvac() {
		return "/directory/reviewvac";
	}
	
	@RequestMapping("/guideap") //manuals
	public String Guideap() {
		return "/directory/guideap";
	}
	
	@RequestMapping("/guideyeelight")
	public String Guideyeelight() {
		return "/directory/guideyeelight";
	}
	
	
}
