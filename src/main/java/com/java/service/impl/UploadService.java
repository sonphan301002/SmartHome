package com.java.service.impl;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {
	@Autowired
	HttpServletRequest request;
	
	// upload ảnh
	public File save(MultipartFile file, String path) {
		if (!file.isEmpty()) {
			File dir = new File(request.getServletContext().getRealPath(path));
			if (!dir.exists()) {
				dir.mkdir();
			}
			try {
				File saveFile = new File(dir, file.getOriginalFilename());
				file.transferTo(saveFile);
				return saveFile;
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException();
			}
		}
		return null;
	}
}
