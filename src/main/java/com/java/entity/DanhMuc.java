package com.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "DanhMuc")
public class DanhMuc implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maDM;
	private String tenDM;
	
	@JsonIgnore
	@OneToMany(mappedBy = "danhMuc")
	List<SanPham> sanPham;
}
