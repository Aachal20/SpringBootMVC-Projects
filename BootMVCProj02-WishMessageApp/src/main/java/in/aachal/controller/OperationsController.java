package in.aachal.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.aachal.service.IWishService;

//@RequestMapping("/wish-operation")
@Controller
public class OperationsController {

	@Autowired
	private IWishService service;

	/*	@RequestMapping("/wish")
		public ModelAndView fetchWishMessage() {  //Working with ModelAndView is legacy style
			String msg = service.generateWishMessage();
			ModelAndView mav = new ModelAndView();
			mav.addObject("wMsg", msg);  //attr name and value
			mav.addObject("sysDate", new Date());  //attr name and value
			mav.setViewName("show_report");
			return mav;
		}
	 */


	/*//good to use
	 @GetMapping("/wish")
	public String showReport(HashMap<String , Object> map) {
		String msg = service.generateWishMessage();
		//Add simple value as the model attribute
		map.put("wMsg" , msg);
		map.put("sysDate",new Date());

		System.out.println("---------------");
		return "show_report";

	}
	 */


	/*@GetMapping("/report")                        //invasive-spring specific
	public String showReport(Model map) {
		//Add simple value as the model attribute
		String msg = service.generateWishMessage();
		map.addAttribute("wMsg" ,msg);
		map.addAttribute("sysDate" ,new Date());

		System.out.println("---------------");
		return "show_report";

	}*/


	/* 
			@GetMapping("/report")         //invasive-spring specific
			public String showReport(ModelMap  map) {
				//Add simple value as the model attribute
				String msg = service.generateWishMessage();
				map.addAttribute("name" , "Ram");
				map.addAttribute("wMsg",msg);
				map.addAttribute("sysDate" , new Date());

				System.out.println("---------------");
				return "show_report";

			}
	 */




	//best
	/*  @GetMapping("/report")
	public String   showReport(Map<String , Object> map) {
		//Add simple value as the model attribute
		map.put("name" , "Rani");
		map.put("age", 22);
		String wishMessage = service.generateWishMessage();
		map.put("wishM", wishMessage);
		map.put("addrs" , "hyd");
		map.put("sysDate" ,new Date());
	

		System.out.println("---------------");
		return "show_report";

	}*/


	/*//Bad
	  @GetMapping("/wish")
		public ModelMap   showReport() {
			//Add simple value as the model attribute
		 ModelMap map = new BindingAwareModelMap();
		 map.put("sysDate" ,new Date());

			System.out.println("---------------");
			return map;

		}*/

	/*
	  @GetMapping("/wish")
		public Model   showReport() {
			//Add simple value as the model attribute
		 Model map = new BindingAwareModelMap();
		 map.addAttribute("sysDate" ,new Date());

			System.out.println("---------------");
			return map;

		}*/



	/*  @GetMapping("/wish")
		public Map<String,Object>   showReport() {
			//Add simple value as the model attribute
		 Map<String,Object>  map = new HashMap();
		 map.put("sysDate" ,new Date());

			System.out.println("---------------");
			return map;

		}*/

	//what happend if we take RT as a void
	//Req path url as a logical view name
	/*@GetMapping("/wish")
	public void   showReport(Map<String , Object> map) {
		//Add simple value as the model attribute
		map.put("name" , "Rani");
		map.put("age", 22);
		map.put("addrs" , "hyd");
		map.put("sysDate" ,new Date());
	
		System.out.println("---------------");
		return ;
	
	}*/
	
	/*	@GetMapping("/wish")
		public String   showReport(Map<String , Object> map) {
			//Add simple value as the model attribute
			map.put("name" , "Rani");
			map.put("age", 22);
			map.put("addrs" , "hyd");
			map.put("sysDate" ,new Date());
	
			System.out.println("---------------");
			return null ;
	
		}
		*/
	
	//directly send a resposne to a browser
	/*@GetMapping("/report")
	public String   showReport(HttpServletResponse res) throws IOException {
		String msg = service.generateWishMessage();
		//get printWriter class obj
		PrintWriter pw = res.getWriter();
		pw.println("<h1>Wish Message ::"  +msg+" </h1>");
		pw.println("<h1>system date and time  ::"  +new Date()+" </h1>");
		
		System.out.println("---------------");
		return null ;
	
	}*/
	
	
	/*@RequestMapping("/report")
	public String   showReport()  {
		return  "show_report";
	
	}
	
	
	@RequestMapping("/REPORT")
	public String   showReport1()  {
		return  "wish";
	}
	*/
	
	
	/*
	@RequestMapping({"/report" , "/REPORT" ,"report2","report3"})
	public String   showReport()  {
		return  "show_report";
	
	}
	*/
	
	/*@RequestMapping("/")
	public String   showReport()  {
		return  "show_report";
	
	}
	
	*/
	
	
	/*@RequestMapping(value="/report" ,  method=RequestMethod.GET)
	//@GetMapping("/report")
	public String   showReport()  {
		return  "welcome";
	
	}*/
	
	/*//@PostMapping("/report")
	@GetMapping("/report")
	public String   showReport()  {
		return  "welcome";
	
	}*/
	
	
	@GetMapping("/a")
	public String   showReport2()  {
		System.out.println("OperationsController.showReport2()-----1");
		//return  "show_report";
		//return  "forward:test-opeartions/all";
		return "forward:all";
	}
	
	@GetMapping("/all")
	public String   showReport3()  {
		System.out.println("OperationsController.showReport3()---2");
		//return  "show_report";
		//return  "forward:test-opeartions/all";
		//return "forward:all";
		return "welcome";
	}
	
	@GetMapping("/b")
	public String   showHomeReport1()  {
		System.out.println("OperationsController.showHomeReport1()");
		//return  "forward:all";
		return  "redirect:test-opeartions/all";
		//return "redirect:all";        //working

	}
}
