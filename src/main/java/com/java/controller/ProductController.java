package com.java.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.java.dao.ProductDAO;
import com.java.entity.Product;
 
import com.java.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
 
 
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<Long> cid) { //RequestPa -> tham số tuỳ chọn theo "cid", Optional -> tham số - đưa mã loại
		if (cid.isPresent()) { // nếu có
			List<Product> list = productService.findByCateId(cid.get()); //Truy vấn lọc sản phẩm theo loại, chỉ lấy mã loại id (get)
			model.addAttribute("items", list); //Truy xuất sản phẩm theo loại
		} else {
			model.addAttribute("items", productService.findAll()); //Truy xuất tất cả sản phẩm
		}
		return "/product/product";
	}
	
	@RequestMapping("productDetail/{maSP}") //dựa masp, lấy sản phẩm từ csdl -> chuyển sang màn hình giao diện thông tin chi tiết// 
	public String detail(Model model, @PathVariable("maSP") Long maSP) { //lấy mã sản phẩm thông qua pathvariable
		Product item = productService.findById(maSP); //truy vấn lấy sản phẩm theo mã ->findbyid
		model.addAttribute("item",item); //đưa sản phẩm bên trong model
		
		return "/product/product-detail";
	}
	
	@RequestMapping("/search")
	public String search(ModelMap model, @RequestParam("keyword") String keyword) {
		List<Product> list = null;
		
		if(StringUtils.hasText(keyword)) {
			list = productService.findByTensp(keyword);
		}else {
			list = productService.findAll();
		}
		
		model.addAttribute("items", list);
		
		return "/product/product";
		
		
 }
	
//	@RequestMapping("/sort")
//	public String sort(Model model, @RequestParam("cid") Optional<Long> cid,
//			@SortDefault(sort = "name", direction = Direction.ASC) Sort sort) { //RequestPa -> tham số tuỳ chọn theo "cid", Optional -> tham số - đưa mã loại
//		Iterable<Product> slist = productService.findAll(sort);
//		if (cid.isPresent()) { // nếu có
//			List<Product> list = productService.findByCateId(cid.get()); //Truy vấn lọc sản phẩm theo loại, chỉ lấy mã loại id (get)
//			model.addAttribute("items", list); //Truy xuất sản phẩm theo loại
//		} else {
//			model.addAttribute("items", productService.findAll()); //Truy xuất tất cả sản phẩm
//		}
//		return "/product/product";
//	}
//	

	// @RequestMapping("/page")
	// public String paginate(Model model, @RequestParam("cid") Optional<Long> cid,
	// 		@PageableDefault(size = 5, direction = Direction.ASC) Pageable pageable) { //RequestPa -> tham số tuỳ chọn theo "cid", Optional -> tham số - đưa mã loại
	// 	Page<Product> pages = productService.findAll(pageable);
	// 	if (cid.isPresent()) { // nếu có
	// 		List<Product> list = productService.findByCateId(cid.get()); //Truy vấn lọc sản phẩm theo loại, chỉ lấy mã loại id (get)
	// 		model.addAttribute("items", list); //Truy xuất sản phẩm theo loại
	// 	} else {
	// 		model.addAttribute("items", productService.findAll()); //Truy xuất tất cả sản phẩm
	// 	}
	// 	List<Sort.Order> sortOrders = pages.getSort().stream().collect(Collectors.toList());
	// 	if(sortOrders.size() >0) {
	// 		Sort.Order order = sortOrders.get(0);
	// 		model.addAttribute("sort", order.getProperty() + " , "
	// 				+ (order.getDirection()== Sort.Direction.ASC?"asc": "desc"));
	// 	}else {
	// 		model.addAttribute("sort", "name");
	// 	}
	// 	model.addAttribute("pages",pages);
	// 	return "/product/product";
	// }
	
	@RequestMapping("/paginate")
	public String paginate(Model model,
			@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Product> page = productService.findAll(pageable);
		model.addAttribute("page",page);
		return "/product/product";
	}
	 
 
	 
	
}
