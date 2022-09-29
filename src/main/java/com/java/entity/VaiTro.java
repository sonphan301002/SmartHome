package com.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "VaiTro")
public class VaiTro implements Serializable{
	@Id
	private String maVT;
	private String tenVT;
	
	@JsonIgnore
	@OneToMany(mappedBy = "vaiTro")
	List<PhanQuyen> phanQuyen;
}
