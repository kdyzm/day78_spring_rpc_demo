package com.kdyzm.rpc.client;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdyzm.domain.Page;
import com.kdyzm.domain.Question;
import com.kdyzm.domain.Survey;
import com.kdyzm.service.SurveyService;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		/*WelcomeService service=(WelcomeService) context.getBean("wsClient");
		service.say("狗蛋");*/
		SurveyService surveyService=(SurveyService) context.getBean("surveyClient");
		Collection<Survey>surveys=surveyService.getAllAvailableSurveys();
		for(Survey survey:surveys){
			System.out.println(survey.getSurveyId()+"_"+survey.getTitle());
			//使用transient关键字实现对字段的屏蔽（不序列化）
			if(survey.getPages()!=null)
			for(Page page:survey.getPages()){
				System.out.println("\t"+page.getPageId()+"_"+page.getOrderNo());
				for(Question question:page.getQuestions()){
					System.out.println("\t\t"+question.getQuestionId()+"_"+question.getTitle());
				}
			}
		}
	}
}
