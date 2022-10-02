package com.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable{
	@Id
	private String tenND;
	private String maVT;
	private String matKhau;
	@Column(columnDefinition = "nvarchar(50)")
	private String hoTen;
	private boolean gioiTinh;
	private String email;
	private String SDT;
	@Column(columnDefinition = "nvarchar(150)")
	private String diaChi;
	private String CMND;
	private String hinhAnh;
	
	@JsonIgnore
	@OneToMany(mappedBy = "taiKhoan")
	List<HoaDon> hoaDon;
	
	@JsonIgnore
	@OneToMany(mappedBy = "taiKhoan")
	List<DanhGia> danhGia;
	
	@JsonIgnore
	@OneToMany(mappedBy = "taiKhoan", fetch = FetchType.EAGER)
	List<PhanQuyen> phanQuyen;
}
