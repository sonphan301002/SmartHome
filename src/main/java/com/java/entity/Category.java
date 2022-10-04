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
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maDM;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenDM;
	
	@JsonIgnore
	@OneToMany(mappedBy = "danhMuc")
	List<Product> sanPham;
}
