package com.cg.app.circuitbreaker.hello.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class HelloResource {

	
	@GetMapping
	public String world()
	{
		System.out.println("hello");
		return "Hello World";
	}
}
