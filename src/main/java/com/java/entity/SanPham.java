package com.java.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maSP;
	private String tenSP;
	private double giaNhap;
	private int soLuong;
	private int trangThai;
	private String moTa;
	private String hinhAnh;
	@Temporal(TemporalType.DATE)
	private Date ngayTao;
	@Temporal(TemporalType.DATE)
	private Date ngaySua;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sanPham")
	List<DanhGia> danhGia;
	
	@ManyToOne
	@JoinColumn(name = "maDM")
	DanhMuc danhMuc;
	
	@ManyToOne
	@JoinColumn(name = "maNCC")
	NhaCungCap nhaCungCap;
}
