package org.amazon.restwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServiceRestController {
	
	private final CommonService commonService;
	
	@Autowired
	Environment env;
	
	@Autowired
	public WebServiceRestController(CommonService commonService) {
		this.commonService = commonService;
	}
	
	@GetMapping("/")
	public String getWelcomeMessage() {
		return commonService.getWelcomeMessage();
	}
}