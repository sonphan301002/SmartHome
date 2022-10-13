package com.java.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.Authority;
import com.java.service.AuthorityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {
	@Autowired
	AuthorityService authorityService;
	
	@GetMapping
	public List<Authority> getAll(@RequestParam("admin") Optional<Boolean> admin) {
		if (admin.orElse(false)) {
			return authorityService.findAuthoritiesOfAdministrators();
		}
		
		return authorityService.findAll();
	}
	
	@PostMapping
	public Authority post(@RequestBody Authority authority) {
		return authorityService.create(authority);
	}
	
	@DeleteMapping("{maPQ}")
	public void delete(@PathVariable("maPQ") Long maPQ) {
		authorityService.delete(maPQ);
	}
}
