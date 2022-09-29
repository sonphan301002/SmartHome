package com.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maNCC;
	private String tenNCC;
	private String logo;
	private String moTa;
	
	@JsonIgnore
	@OneToMany(mappedBy = "nhaCungCap")
	List<SanPham> sanPham;
}
