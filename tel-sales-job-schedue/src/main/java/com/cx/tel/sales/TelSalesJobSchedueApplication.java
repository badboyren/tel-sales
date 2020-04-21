package com.cx.tel.sales;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.cx.tel.sales")
@EnableAutoConfiguration
@MapperScan("com.cx.tel.sales.mapper")
@EnableTransactionManagement
public class TelSalesJobSchedueApplication {
	public static void main(String[] args) {
		SpringApplication.run(TelSalesJobSchedueApplication.class, args);
	}
}
