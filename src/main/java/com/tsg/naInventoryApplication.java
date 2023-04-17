package com.tsg;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class naInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(naInventoryApplication.class, args);
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
// when  we add validation api dependency with Hibernate we don't need to create the validator bean
//    @Bean
//    Validator validator() {
//        return new LocalValidatorFactoryBean();
//    }

}