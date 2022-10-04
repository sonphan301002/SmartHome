package com.java.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "DanhGia")
public class Comment implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maDG;
	private int xepHang;
	@Column(columnDefinition = "nvarchar(max)")
	private String noiDung;
	@Temporal(TemporalType.DATE)
	private Date ngayTao;
	@Temporal(TemporalType.DATE)
	private Date ngaySua;
	
	@ManyToOne
	@JoinColumn(name = "tenND")
	Account taiKhoan;
	
	@ManyToOne
	@JoinColumn(name = "maSP")
	Product sanPham;
}
