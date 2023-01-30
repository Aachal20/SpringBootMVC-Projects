package in.aachal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test-operations")
@Controller
public class TestController {
	
		@GetMapping("/all")
		public String   showReport1()
		{
			System.out.println("TestController.showReport1-------22()");
			return  "show_report";
		
		}
		
}
