package com.nt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.PurchaseOrderImpl;

@SpringBootApplication
public class SpringBootMail01SendMailApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootMail01SendMailApplication.class, args);
		PurchaseOrderImpl pp = ctx.getBean("purchase" , PurchaseOrderImpl.class);
		try {
			//invoke service method
			String msg = pp.purchase(new String[] {"Laptop" , "One Pluse Phone " , "Creta 45854"}, new double[] {60000.0, 22000.60,100000.3},new String[] {"chavadayash16@gmail.com" , "mozareaachal999@gmail.com"});
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();

		}
		//close container
		ctx.close();
	}
	//
}
