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
public class Account implements Serializable{
	@Id
	private String tenND;
	private String maVT;
	private String matKhau;
	@Column(columnDefinition = "nvarchar(50)")
	private String hoTen;
	private boolean gioiTinh;
	private String email;
	private String sdt;
	@Column(columnDefinition = "nvarchar(150)")
	private String diaChi;
	private String cmnd;
	private String hinhAnh;
	
	@JsonIgnore
	@OneToMany(mappedBy = "taiKhoan")
	List<Order> hoaDon;
	
	@JsonIgnore
	@OneToMany(mappedBy = "taiKhoan")
	List<Comment> danhGia;
	
	@JsonIgnore
	@OneToMany(mappedBy = "taiKhoan", fetch = FetchType.EAGER)
	List<Authority> phanQuyen;
}
