package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component("purchase")
public class PurchaseOrderImpl implements IPurchaseOrder {

	@Autowired
	private JavaMailSender mailSender;

	@Value("{spring.mail.username}")
	private String fromEmail;

	@Override
	public String purchase(String[] items, double[] prices, String[] toEmails) throws Exception {
		double billAmt = 0.0;
		for(double price:prices) 
			billAmt = billAmt+price;
		String msg = Arrays.toString(items)+ " with prises" +Arrays.toString(prices)+ "--are purchased with billAmount"+billAmt;
		//send mail
		String status = sendMail(msg,toEmails);
		return msg+ " ---------" +status;
	}

	public String sendMail(String msg , String[] toEmails) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("Hi , Job regarding");
		helper.setSentDate(new Date());
		helper.setText(msg);
		//helper.addAttachment("nit.jpg", new ClassPathResource("nit.jpg"));
		mailSender.send(message);
		return "MAIL SUCCESSFULLY SEND";
	}
}
