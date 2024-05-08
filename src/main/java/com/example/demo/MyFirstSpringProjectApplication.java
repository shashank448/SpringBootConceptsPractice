package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

@PropertySource("classpath:extra.properties")
@SpringBootApplication
public class MyFirstSpringProjectApplication implements ApplicationRunner {

	@Value("${key}")
	private String myVal;
	@Value("${hostname}")
	private String myHost;

	@Value("${dynamodb.username}")
	private String dynamouser;

	public static void main(String[] args) {

		System.out.println("Hello ");
		ApplicationContext ctx = SpringApplication.run(MyFirstSpringProjectApplication.class, args);
		/*for(String bean : ctx.getBeanDefinitionNames())
			System.out.println(bean);
*/
		DatabaseAccessor databaseAccessor = (DatabaseAccessor) ctx.getBean("databaseAccessor");
		databaseAccessor.talkToDB();
		GameManager gameManager = (GameManager) ctx.getBean("MyGameManager");
		gameManager.manage();

		AWS aws = (AWS)ctx.getBean("AWS");
		System.out.println(aws.getUserName()+" "+aws.getPassword());
	}
	@Override
	public void run(ApplicationArguments args) throws Exception{
		System.out.println(myVal+" "+myHost+" "+dynamouser);
	}

}
