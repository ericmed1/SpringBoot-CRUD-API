package com.example.demo;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.demo.models")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}