package com.server.asynchronous.model;

import org.springframework.web.context.request.async.CallableProcessingInterceptor;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.concurrent.Callable;

public class CustomCallableProcessingInterceptor implements CallableProcessingInterceptor {

	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) {
		return "error/timeoutError";
	}
}
