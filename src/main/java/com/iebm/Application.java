package com.iebm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableCaching
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws InterruptedException {

		ApplicationContext ctx = new SpringApplicationBuilder().sources(Application.class).run(args);
		String serverName = ctx.getEnvironment().getProperty("spring.application.name");

		logger.info("======" + serverName + " Server Startup success!======");

	}
}