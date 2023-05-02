package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Controller와 ResponseBody가 하나로 엮인 어노테이션
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@GetMapping
//	public String HelloWorld(){
//		return "HelloWorld!!"; // 이렇게 적으면 resource 안에 있는 HelloWorld!!의 이름을 가진 파일로 이동
//	}
	@GetMapping(value = "/")
	public String HelloWorld(){
		return "HelloWorld!!";
	}
}
