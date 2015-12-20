package com.kdyzm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdyzm.rpc.server.WelcomeService;

public class ServerTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		WelcomeService welcomeService=(WelcomeService) context.getBean("welcomeService");
		welcomeService.say("小明");
	}
}
