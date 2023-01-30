package in.aachal.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentRequestParamsController {

	/*@GetMapping("/data")
	public String process(@RequestParam("sno") int no,@RequestParam("sname") String name) {
		System.out.println(no+" "+name);
		//return lvn
		return "show_result";
	}*/
	
	/*	
		@GetMapping("/data")
	//	public String process(@RequestParam int sno,@RequestParam(required=false,defaultValue = "ram") String sname) {
		public String process(@RequestParam int sno,@RequestParam(defaultValue = "ram") String sname) {
			System.out.println(sno+" "+sname);
			//return lvn
			return "show_result";
		}*/
	

	/*	@GetMapping("/data")
	public String process(@RequestParam int sno) {       //NFException
			System.out.println(sno);
			//return lvn
			return "show_result";
		}*/
	
	
	/*//array , list ,set
	@GetMapping("/data")
	
		public String process(@RequestParam(name="sno",required=false)Integer sno,@RequestParam("sname") String sname,
				                                                            @RequestParam("sadd") String addrs[],@RequestParam("sadd")List<String> saddList,
				                                                              @RequestParam("sadd") Set<String> saddSet ) {
			System.out.println(sno+" "+sname+" " +Arrays.toString(addrs)+" "+saddList+" "+saddSet);
			//return lvn
			return "show_result";
		}*/
	
	
	//array , list ,set
		@GetMapping("/data")
		
			public String process(@RequestParam(name="sno",required=false)Integer sno,@RequestParam("sname") String sname,
					                                                            @RequestParam("sadd") String addrs ) {
				System.out.println(sno+" "+sname+" " +addrs);
				//return lvn
				return "show_result";
			}
}
