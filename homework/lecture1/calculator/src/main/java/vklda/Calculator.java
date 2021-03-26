package vklda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Calculator {
    @Autowired
    Processor processor;

    public static void main(String[] args) {
        SpringApplication.run(Calculator.class, args);
    }




}
