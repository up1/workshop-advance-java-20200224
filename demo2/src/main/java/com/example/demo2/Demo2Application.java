package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static java.lang.System.*;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(Demo2Application.class, args);
		String[] beans = context.getBeanDefinitionNames();
		for (String bean: beans) {
			out.println(bean);
		}
		out.println(context.getBeanDefinitionCount());
	}

}
