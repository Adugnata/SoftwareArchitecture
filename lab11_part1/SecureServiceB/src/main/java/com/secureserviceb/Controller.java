package com.secureserviceb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/phone")
	public String getGetContact() {
		return "678920042";
	}
}

