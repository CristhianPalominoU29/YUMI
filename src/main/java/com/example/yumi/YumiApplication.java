package com.example.yumi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.yumi")
public class YumiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YumiApplication.class, args);
	}

}
//--enable-native-access=ALL-UNNAMED