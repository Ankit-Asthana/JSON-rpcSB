package com.example.jsonrpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.service", "com.example.rpc"})
public class JsonrpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonrpcApplication.class, args);
	}

}
