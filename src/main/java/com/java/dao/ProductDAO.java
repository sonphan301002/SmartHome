package com.java.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entity.CateStatsReport;
import com.java.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{
	@Query("select p from Product p where p.danhMuc.maDM=?1") //Câu lệnh lấy sản phẩm theo mã loại giống tham số đã truyền vào
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
	
	@Query(value = "CALL sp_ThongKeDoanhThu (?)", nativeQuery = true )
    List<Object[]> thongKeDoanhThu(int nam);
    
//Thống kê doanh thu bán được trong ngày hôm nay     
    @Query(value = "select hd.ngay_tao, SUM(((sp.gia*ct.so_luong)*(100-ct.giam_gia)/100)) as TongTien,\r\n"
    		+ "SUM(ct.so_luong) as SPDaBan,\r\n"
    		+ "Min(((sp.gia*ct.so_luong)*(100-ct.giam_gia)/100)) as HDThapNhat,\r\n"
    		+ "Max (((sp.gia*ct.so_luong)*(100-ct.giam_gia)/100)) as HDCaoNhat,\r\n"
    		+ "ROUND(AVG(((sp.gia*ct.so_luong)*(100-ct.giam_gia)/100)),2) as TrungBinh\r\n"
    		+ "\r\n"
    		+ "from hoa_don hd \r\n"
    		+ "		inner join hoa_don_chi_tiet ct on ct.mahd = hd.mahd\r\n"
    		+ "		inner join san_pham sp on sp.masp = ct.masp where hd.trang_thai = 2 and hd.ngay_tao = CONVERT(date, GETDATE(), 103)\r\n"
    		+ "GROUP BY  hd.ngay_tao", nativeQuery = true)
    List<Object[]> getDoanhThuNgayHomNay();

    
//    Thống kê sản phẩm bán được trong ngày hôm nay
    @Query(value = "select h.mahd, sp.tensp,sp.gia,SUM(ct.so_luong) as SoLuong, dmsp.tendm,\r\n"
    		+ "		((sp.gia*ct.so_luong)*(100-ct.giam_gia)/100) as ThanhTien\r\n"
    		+ "from hoa_don_chi_tiet ct\r\n"
    		+ "		inner join san_pham sp on sp.MaSP = ct.MaSP  \r\n"
    		+ "		inner join hoa_don h on h.mahd=ct.mahd\r\n"
    		+ "		inner join danh_muc dmsp on dmsp.MaDM = sp.MaDM\r\n"
    		+ "where ct.mahd is not null and h.ngay_tao = CONVERT(date, GETDATE(), 103)\r\n"
    		+ "group by h.mahd, sp.tensp,sp.gia,ct.so_luong,h.ngay_tao, dmsp.tendm,((sp.gia*ct.so_luong)*(100-ct.giam_gia)/100)", nativeQuery = true)
    List<Object[]> getSanPhamBanDuoc();
    
    
//    Thống kê số lượng sản phẩm theo loại
    @Query("SELECT new CateStatsReport(o.danhMuc, sum(o.gia), count(o)) "
    		+ " FROM Product o "
    		+ " GROUP BY o.danhMuc"
    		+ " ORDER BY sum(o.gia) DESC")
    List<CateStatsReport> getInventoryByCategory();



 

	
//	@Query("SELECT o FROM Product o WHERE o.tenSP LIKE ?1")
//	@Query("SELECT o FROM Product o WHERE CONCAT(o.maSP, o.tenSP, o.danhMuc.tenDM, o.nhaCungCap.tenNCC) LIKE ?1")
	
//	@Query("SELECT * FROM Product"
//			+ "ORDER BY TenSP, gia")
//	
//	@Query("SELECT * FROM Product"
//			+ "ORDER BY tenSP, gia DESC")
	
//	  List<Product> findAllByGiaSP(double gia, Pageable pageable);
	
//	@Query("SELECT new Report(o.product , sum(o.gia), count(o)) "
//			+ " FROM Product o "
//			+ " GROUP BY o.product"
//			+ " ORDER BY sum(o.gia) DESC")
//	List<Report> getInventoryByCategory();
	
//	Page<Product> findByKeywords(String keywords, Pageable pageable);
//
//	Page<Product> findAllByTenspLike(String keywords, Pageable pageable);
	
//	@Query("SELECT p FROM Product p WHERE p.tenSP LIKE %?1%"
//            + " OR p.maSP LIKE %?1%"
//			+ " OR p.danhMuc.tenDM LIKE %?1%" )
// 	Page<Product> findAllByTenspLike(String keyword, Pageable pageable);
}