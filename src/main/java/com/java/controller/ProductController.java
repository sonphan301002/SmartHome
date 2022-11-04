package com.java.controller;

import java.util.List;
import java.util.Optional;

import com.java.entity.Product;
import com.java.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<Long> cid) {
		if (cid.isPresent()) { // nếu có
			List<Product> list = productService.findByCateId(cid.get());
			model.addAttribute("items", list);
		} else {
			model.addAttribute("items", productService.findAll());
		}
		return "/product/product";
	}
	
	@RequestMapping("productDetail/{maSP}")
	public String detail(Model model, @PathVariable("maSP") Long maSP) {
		Product item = productService.findById(maSP);
		model.addAttribute("item",item);
		
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
	
//	@RequestMapping("searchpaginated")
//	public String search(ModelMap model, 
//			@RequestParam(name = "keyword", required = false) String keyword, 
//			@RequestParam("page") Optional<Integer> page,
//			@RequestParam("size") Optional<Integer> size) {
//		
//		int currentPage = page.orElse(1);
//		int pageSize = size.orElse(5);
//		
//		Pageable pageable = PageRequest.of(currentPage-1, pageSize, Sort.by("keyword"));
//		Page<Product> resultPage = null;
//		
//		if(StringUtils.hasText(keyword)) {
//			resultPage = productService.findAllByTenspLike(keyword, pageable);
//			model.addAttribute("keyword", keyword);
//		}else {
//			resultPage = productService.findAll(pageable);
//		}
//		
//		int totalPages = resultPage.getTotalPages();
//		if(totalPages > 0) {
//			int start = Math.max(1, currentPage-2);
//			int end = Math.min(currentPage + 2, totalPages);
//			
//			if(totalPages > 5) {
//				if(end == totalPages) start = end -5;
//				else if(start == 1) end = start +5;
//			}
//			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
//					.boxed()
//					.collect(Collectors.toList());
//					
//			model.addAttribute("pageNumbers", pageNumbers);		
//		}
//		
//		model.addAttribute("productPage", resultPage);
//		
//		return " ";
//	}
	
}
