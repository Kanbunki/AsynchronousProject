package com.server.asynchronous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Callable;

import com.server.asynchronous.model.*;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Autowired
	AsyncUploader uploader;

	@RequestMapping(method=RequestMethod.GET)
	public String forwardToUploadForm() {
		return "uploadForm";
	}
	
	@RequestMapping(method=RequestMethod.POST, params="upload")
	public CompletableFuture<String> upload(@RequestParam MultipartFile file) {
		CompletableFuture<String> cf = uploader.upload(file);
		System.out.println("Return View: " + LocalTime.now());
		return cf;
	}
	
	@RequestMapping(value="/complete", method=RequestMethod.GET)
	public String completedUploading() {
		return "completedUploading";
	}
	
	@RequestMapping(method=RequestMethod.POST, params="download")
	public Callable<String> download() throws InterruptedException {
		return uploader.download();
	}
}
