package in.aachal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {

	@RequestMapping("/")
	public String  showHome(){
	  return "welcome";	
	}
	
	@RequestMapping("/hi")
	public String showWelcomPage() {
		return "hello";
	}
}
