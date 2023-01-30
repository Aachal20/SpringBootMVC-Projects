package in.aachal.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import in.aachal.service.IWishService;

@RequestMapping("aaa")
@Controller
public class WishMessageController {

	@Autowired
	private IWishService service;
	
	@Autowired
	private ServletConfig cg;
	
	@Autowired
	private ServletContext sc;
	
	@Autowired
	private HttpSession ses;
	
	/*@RequestMapping("/all")
	public String   showReport1()  {
		System.out.println();
		System.out.println("WishMessageController.showReport1()");
		System.out.println("Web Appliocation Name :: " +sc.getContextPath());
		System.out.println("Session Id :::: "   +ses.getId());
		System.out.println("DS Logical Name :: " +cg.getServletName());
		return  "show_report";
	
	}*/
	
	
	/*@RequestMapping("/all")
	public String   showReport1(ServletConfig cg, ServletContext sc ,HttpSession ses)  {
		System.out.println();
		System.out.println("WishMessageController.showReport1()");
		System.out.println("Web Appliocation Name :: " +sc.getContextPath());
		System.out.println("Session Id :::: "   +ses.getId());
		System.out.println("DS Logical Name :: " +cg.getServletName());
		return  "show_report";
	
	}*/
	
	@RequestMapping("/all")
	public String   showReport1(HttpSession ses)  {
		System.out.println();
		
		System.out.println("Web Appliocation Name :: " +sc.getContextPath());
		System.out.println("Session Id :::: "   +ses.getId());
		
		return  "show_report";
	
	}
}
