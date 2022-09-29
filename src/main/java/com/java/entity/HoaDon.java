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
@Table(name = "HoaDon")
public class HoaDon implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maHD;
	@Temporal(TemporalType.DATE)
	private Date ngayBan;
	private int trangThai;
	@Temporal(TemporalType.DATE)
	private Date ngayTao;
	@Temporal(TemporalType.DATE)
	private Date ngaySua;
	
	@ManyToOne
	@JoinColumn(name = "tenND")
	TaiKhoan taiKhoan;
	
	@JsonIgnore
	@OneToMany(mappedBy = "hoaDon")
	List<HoaDonChiTiet> hoaDonChiTiet;
}
