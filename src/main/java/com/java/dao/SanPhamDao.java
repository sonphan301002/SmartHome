package com.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.entity.SanPham;

public interface SanPhamDao extends JpaRepository<SanPham, Long>{
	@Query("select sp from SanPham sp where sp.danhMuc.maDM=?1")
	List<SanPham> findByCateId(Long cid);
	
	@Query(value = "select top 4 hdct.masp, count(hdct.masp) as 'so luong', sp.tensp, sp.gia, sp.hinh_anh\r\n"
			+ "from hoa_don_chi_tiet hdct inner join san_pham sp on sp.masp = hdct.masp\r\n"
			+ "GROUP BY hdct.masp, sp.tensp, sp.gia, sp.hinh_anh order by hdct.masp asc", nativeQuery = true )
	List<SanPham> findByBestSeller();
}
