package com.baobaotao.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Static
 */
@Configuration
public class Beans {
    @Bean(name = "testB1")
    public TestB getOne() {
        TestB testB = new TestB();
        testB.setAge(30);
        testB.setName("Static");
        return testB;
    }
}