package com.server.asynchronous.model;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Callable;

import com.server.asynchronous.service.*;

@Component
public class AsyncUploader {

	@Autowired
	UploadService uploadService;
	
	@Async
	public CompletableFuture<String> upload(MultipartFile file) {
		
		try {
			uploadService.upload(file);
			Thread.sleep(6000);
			System.out.println("Upload Completed: " + LocalTime.now());
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture("uploadCompleted");
	}
	
	
	public Callable<String> download() throws InterruptedException {
		
		return new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(8000);
				System.out.println("Download Completed: " + LocalTime.now());
				return "downloadCompleted";
			}
		};
	}
}
