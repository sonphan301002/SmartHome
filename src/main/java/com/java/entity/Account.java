package com.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TaiKhoan")
public class Account implements Serializable{
	@Id
	@NotEmpty
	@Length(min=3)
	private String tenND;
	private String maVT;
	@Length(min=3)
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
	
	@Enumerated(EnumType.STRING)
	@Column (name="auth_provider")
	private AuthenticationProvider authProvider;
	
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
