package in.aachal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.aachal.model.Product;

@Controller
public class DataRederingController {

	/*@GetMapping("/")
	public String showHomePage(Map<String,Object> map) {
		//add simple values as the model attribute 
		map.put("Name", "Deepika");
		map.put("Age" , "25");
		map.put("adrs", "Lundon");
		//return LVN
		return "welcome";
	}*/
	
	@GetMapping("/report")
	public String showHomePage(Map<String,Object> map) {
		//add simple values as the model attribute 
		map.put("favColors" ,new String[] { "red","Green","Pink","Yellow" ,"Purple"});
		
		
		map.put("nickNames", List.of("Aachal" ,"Radha" ,"Sham" ," Rohit","aachal","Rohit"));
		
		map.put("phoneNos", Set.of(77788887777L , 88888888888L, 5555555555L,3333333333L));
		map.put("idDetails" , Map.of("Aadhar", "576232786386L", "panNo" , "789798798H" , "voterId" , "346837246384GG"));
		//return LVN
		return "welcome";
	}
	
	/*@GetMapping("/report")
	public String showHomePage(Map<String,Object> map) {
		//Create model class obj having record/data(Generally this object comes from DAO , service classes
		//having db table record
		Product prod = new Product(101, "Laptop" , 550000.5 , 1);
		map.put("product", prod);
		
		//return LVN
		return "welcome";
	}*/
	
	@GetMapping("/reportt")
	public String showHomePage1(Map<String,Object> map) {
		//Create model class obj having record/data(Generally this object comes from DAO , service classes
		//having db table record
		//list of model class obj
		List<Product> list = List.of(new Product(1,"Table" , 5000.3,2) , new Product(2 , "Book" , 55.2,5),new Product(3,"lappi",6000.3,1));
		
		map.put("prodList", list);
		
		//return LVN
		return "welcome";
	}
}
