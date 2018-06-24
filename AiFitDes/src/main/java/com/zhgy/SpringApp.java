package com.zhgy;

import com.zhgy.util.GetSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApp {

	public static void main(String[] args) {
		GetSession.getSession();
		SpringApplication.run(SpringApp.class, args);
	}

}
