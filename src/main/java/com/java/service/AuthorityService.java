package com.java.service;

import java.util.List;

import com.java.entity.Authority;

public interface AuthorityService {

	List<Authority> findAuthoritiesOfAdministrators();

	List<Authority> findAll();

	Authority create(Authority authority);

	void delete(Long maPQ);

}
