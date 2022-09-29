package com.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private String hoTen;
	private boolean gioiTinh;
	private String email;
	private String SDT;
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
