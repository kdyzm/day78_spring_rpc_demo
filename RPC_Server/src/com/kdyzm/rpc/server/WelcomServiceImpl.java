package com.kdyzm.rpc.server;

public class WelcomServiceImpl implements WelcomeService{

	@Override
	public String say(String name) {
		System.out.println("你好,"+name);
		return name;
	}
}
