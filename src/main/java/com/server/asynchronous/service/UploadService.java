package com.server.asynchronous.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

@Service
public class UploadService {

	public void upload(MultipartFile file) {
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println("Completed uploading");
	}
}
