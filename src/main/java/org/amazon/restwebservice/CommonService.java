package org.amazon.restwebservice;

import org.springframework.stereotype.Service;

@Service
public class CommonService {
	public String getWelcomeMessage() {
		return "Welcome to my Webservices";
	}
}
