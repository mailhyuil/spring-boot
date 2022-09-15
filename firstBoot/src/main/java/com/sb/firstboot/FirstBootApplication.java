package com.sb.firstboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sb.firstboot.controller",
								"com.sb.firstboot.service.impl",
								"com.sb.firstboot.repository",
								"com.sb.firstboot.config"})
@EntityScan("com.sb.firstboot.domain")
@MapperScan(value = {"com.sb.firstboot.repository"})
public class FirstBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirstBootApplication.class, args);
	}
}
