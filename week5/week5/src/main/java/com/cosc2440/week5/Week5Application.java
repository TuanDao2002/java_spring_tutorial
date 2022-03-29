package com.cosc2440.week5;

import com.cosc2440.week5.service.FacebookService;
import com.cosc2440.week5.service.MessageService;
import com.cosc2440.week5.service.SMSService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class Week5Application {
	public static void main(String[] args) {
		// Configure with XML
//		 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		// Configure with annotation
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		ChatApplication chatApplication = context.getBean(ChatApplication.class);

		// get the FacebookService bean that is injected to ChatApplication
		MessageService facebookService1 = chatApplication.getMessageService();
		System.out.println(facebookService1);

		// retrieve FacebookService bean from application context
		FacebookService facebookService2 = context.getBean(FacebookService.class);
		// facebookService1 and facebookService2 will have the same address if the scope is singleton (default)
		// if the scope is prototype, they will have different addresses
		System.out.println(facebookService2);

		// set the new MessageService instance to SMSService
		SMSService smsService = context.getBean(SMSService.class);
		chatApplication.setMessageService(smsService);
		chatApplication.getMessageService().send();

		// add List of MessageService to ChatApplication
		ArrayList<MessageService> list = new ArrayList<>();
		list.add(facebookService1);
		list.add(facebookService2);
		list.add(smsService);

		System.out.println("\nBeans with parameters: ");
		ChatApplication newChatApplication = context.getBean(ChatApplication.class, list);
		System.out.println(newChatApplication);
		System.out.println(newChatApplication.getMessageServiceArrayList());

		ChatApplication newChatApplication1 = context.getBean(ChatApplication.class, list);
		System.out.println(newChatApplication1);
		System.out.println(newChatApplication1.getMessageServiceArrayList());
		System.out.println();

		System.out.println("Beans without parameter: ");
		System.out.println(chatApplication);
		ChatApplication chatApplication1 = context.getBean(ChatApplication.class);
		System.out.println(chatApplication1);

	}
}
