package com.cg.app.circuitbreaker.WebSite.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
@EnableHystrix
public class WebsiteResource {

	@Autowired
	private RestTemplate restTemplate;
			
	@RequestMapping("/")
	@HystrixCommand(fallbackMethod = "redirecting")
	public String hello(Model model)
	{
		System.out.println("welcome");
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:7766/client", String.class);
		String message = entity.getBody();
		model.addAttribute("message", message);
		System.out.println(message);
		return "helloWorld";
	}
	
	  public String redirecting(Model model) { 
		  model.addAttribute("message", "Gud morning Foks");
		  return "helloWorld";
		
		  }
	 
}
