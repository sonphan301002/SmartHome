package com.java.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "PhanQuyen", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"tenND", "maVT"})})
public class Authority implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maPQ;
	
	@ManyToOne
	@JoinColumn(name = "tenND")
	Account taiKhoan;
	
	@ManyToOne
	@JoinColumn(name = "maVT")
	Role vaiTro;
}
