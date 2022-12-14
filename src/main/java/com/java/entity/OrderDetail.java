package com.java.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "HoaDonChiTiet")
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maHDCT;
	private int soLuong;
	private double giamGia;
	private double donGia;
	private double VAT;
	
	@ManyToOne
	@JoinColumn(name = "maHD")
	Order hoaDon;
	
	@ManyToOne
	@JoinColumn(name = "maSP")
	Product sanPham;
}
