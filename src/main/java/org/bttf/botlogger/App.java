package org.bttf.botlogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class App {

	@Autowired
	FundController controller;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

//	@PostConstruct
//	public void initTestOrders(){
//		controller.initTestOrders();
//	}
}
