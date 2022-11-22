package com.java.service.impl;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService{
	@Autowired
	ServletContext servletContext;
	
	@Override
	public File save(MultipartFile file, String folder) {
		File dir = new File(servletContext.getRealPath("/assets/" + folder));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// Tạo folder nếu chưa tồn tại
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		// lưu folder
		try {
			File savedFile = new File(dir, name);
			file.transferTo(savedFile);
			System.out.println(savedFile.getAbsolutePath());
			return savedFile;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
	}
}
