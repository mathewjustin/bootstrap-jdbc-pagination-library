package com.jdbc.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jumathew
 *
 */
@SpringBootApplication
@ComponentScan("com.jdbc")
public class JdbcBootstrapPagination1Application {

	public static void main(String[] args) {
		SpringApplication.run(JdbcBootstrapPagination1Application.class, args);
	}
}
