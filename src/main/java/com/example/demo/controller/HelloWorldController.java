package com.example.demo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SpringBootApplication 
public class HelloWorldController {

	 	@RequestMapping("/hello2")
		public String hello2(){
			return "helloworld";
		}
	
}
