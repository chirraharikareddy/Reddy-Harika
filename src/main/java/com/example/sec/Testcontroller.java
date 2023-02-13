package com.example.sec;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {
	@PreAuthorize("hasRole('USER')")
	@GetMapping("hello")
	public String m1() {
	return "helo hi";
	}
	@PreAuthorize("hasRole('MANAGER')")
	@GetMapping("test1")
	public String m2() {
		return "hiii";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("test2")
	public String m3() {
		return "execute";
	}
	

}
