package com.Spring.Learn_Spring_Framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age){ };
record Address(String firstLine, String city){};
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "Krit";
    }

    @Bean
    public int age(){
        return 24;
    }

    @Bean
    public Person person(){
        return new Person("Rishabh", 25);
    }

    @Bean
    public Address address(){
        return new Address("Hari Nagar", "New Delhi");
    }
}
