package com.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{
	@Query("select p from Product p where p.danhMuc.maDM=?1")
	List<Product> findByCateId(Long cid);
	
	@Query("SELECT o FROM Product o WHERE o.tenSP LIKE %?1%")
	List<Product> findByTensp(String keyword);
	
	@Query(value = "select top 4 * from san_pham order by san_pham.ngay_tao asc", nativeQuery = true )
    List<Product> findNewProduct();
	
	@Query(value = "select top 4 * from san_pham where san_pham.madm = 1", nativeQuery = true )
    List<Product> hienThiThietBi();
	
	@Query(value = "select top 4 * from san_pham where san_pham.madm = 2;", nativeQuery = true )
    List<Product> hienThiRobot();
	
	@Query(value = "select top 4 * from san_pham where san_pham.madm = 4;", nativeQuery = true )
    List<Product> hienThimayLoc();
	
//	@Query("SELECT o FROM Product o WHERE o.tenSP LIKE ?1")
//	@Query("SELECT o FROM Product o WHERE CONCAT(o.maSP, o.tenSP, o.danhMuc.tenDM, o.nhaCungCap.tenNCC) LIKE ?1")
//	Page<Product> findByKeywords(String keywords, Pageable pageable);
//
//	Page<Product> findAllByTenspLike(String keywords, Pageable pageable);
	
//	@Query("SELECT p FROM Product p WHERE p.tenSP LIKE %?1%"
//            + " OR p.maSP LIKE %?1%"
//			+ " OR p.danhMuc.tenDM LIKE %?1%" )
// 	Page<Product> findAllByTenspLike(String keyword, Pageable pageable);
}