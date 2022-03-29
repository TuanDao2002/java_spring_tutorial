package com.cosc2440.week5;

import com.cosc2440.week5.service.FacebookService;
import com.cosc2440.week5.service.MessageService;
import com.cosc2440.week5.service.SMSService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Week5Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ChatApplication chatApplication = context.getBean(ChatApplication.class);

		// get the FacebookService bean of ChatApplication
		MessageService facebookService1 = chatApplication.getMessageService();
		System.out.println(facebookService1);

		// retrieve FacebookService bean from beans.xml
		FacebookService facebookService2 = context.getBean(FacebookService.class);
		// facebookService1 and facebookService2 will have the same address if the scope is singleton (default)
		// if the scope is prototype, they will have different addresses
		System.out.println(facebookService2);

		// set the new MessageService instance to SMSService
		SMSService smsService = context.getBean(SMSService.class);
		chatApplication.setMessageService(smsService);
		chatApplication.getMessageService().send();
	}
}
