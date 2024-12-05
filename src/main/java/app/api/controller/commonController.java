package app.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class commonController {
	
	@GetMapping("/api/ij5")
	public String infoIj5() {
		return "ij5";
	}
}
