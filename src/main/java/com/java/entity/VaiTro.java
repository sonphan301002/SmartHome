package com.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "VaiTro")
public class VaiTro implements Serializable{
	@Id
	private String maVT;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenVT;
	
	@JsonIgnore
	@OneToMany(mappedBy = "vaiTro")
	List<PhanQuyen> phanQuyen;
}
