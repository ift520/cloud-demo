package com.ift.consum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * 服务消费方
 *
 * @author liufei
 * @since 0.0.1
 */
@EnableCircuitBreaker
@SpringBootApplication
public class ConsumServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumServiceApplication.class, args);
    }
}
