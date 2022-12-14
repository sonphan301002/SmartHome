package com.java.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "HinhAnh")
public class Image implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maHA;
	private String hinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "maSP")
	Product sanPham;
}
