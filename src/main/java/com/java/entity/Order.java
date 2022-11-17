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
public class Order implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maHD;
	private int trangThai;
	@Temporal(TemporalType.DATE)
	private Date ngayTao;
	@Temporal(TemporalType.DATE)
	private Date ngaySua;
	@Column(columnDefinition = "nvarchar(max)")
	private String ghiChu;
	private int thanhToan;
	@ManyToOne
	@JoinColumn(name = "tenND")
	private Account taiKhoan;
	
	@JsonIgnore
	@OneToMany(mappedBy = "hoaDon")
	private List<OrderDetail> hoaDonChiTiet;
}
