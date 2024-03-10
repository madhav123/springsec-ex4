package com.dizzy.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassworController {
	
	@GetMapping("/encodePass/{code}")
	public String getEncodePassword(@PathVariable String code) {	
		BCryptPasswordEncoder obj= new BCryptPasswordEncoder();
		return obj.encode(code);
	}
	
	

}
