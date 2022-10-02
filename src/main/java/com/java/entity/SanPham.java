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
public class SanPham implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maSP;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenSP;
	private double gia;
	private int soLuong;
	private int trangThai;
	@Column(columnDefinition = "nvarchar(max)")
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
