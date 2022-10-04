package com.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "NhaCungCap")
public class Supplier implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maNCC;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenNCC;
	private String logo;
	@Column(columnDefinition = "nvarchar(max)")
	private String moTa;
	
	@JsonIgnore
	@OneToMany(mappedBy = "nhaCungCap")
	List<Product> sanPham;
}
