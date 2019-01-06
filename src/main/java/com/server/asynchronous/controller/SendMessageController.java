package com.server.asynchronous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import com.server.asynchronous.model.*;

@Controller
@RequestMapping("/greeting")
public class SendMessageController {
	
	@Autowired
	GreetingMessageSender greetingMessageSender;

	@RequestMapping(method=RequestMethod.GET)
	public SseEmitter greeting() throws IOException, InterruptedException {
		SseEmitter emitter = new SseEmitter();
		greetingMessageSender.send(emitter);
		return emitter;
	}
}
