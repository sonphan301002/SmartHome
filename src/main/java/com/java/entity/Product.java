package com.java.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "SanPham")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maSP;
	@Column(columnDefinition = "nvarchar(max)")
	private String tenSP;
	private double gia;
	private int soLuong;
	@Column(columnDefinition = "nvarchar(max)")
	private String moTa;
	private String hinhAnh;
	@Temporal(TemporalType.DATE)
	private Date ngayTao;
	@Temporal(TemporalType.DATE)
	private Date ngaySua;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sanPham")
	List<Comment> danhGia;
	
	@ManyToOne
	@JoinColumn(name = "maDM")
	Category danhMuc;
	
	@ManyToOne
	@JoinColumn(name = "maNCC")
	Supplier nhaCungCap;
}
