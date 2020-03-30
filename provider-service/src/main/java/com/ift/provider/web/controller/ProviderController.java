package com.ift.provider.web.controller;

import com.ift.provider.web.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 服务提供方API
 *
 * @author liufei
 * @since 2020/3/30
 */
@RestController
public class ProviderController {

    private final static Random random = new Random();

    @HystrixCommand(fallbackMethod = "fallbackMethodForGetUsers", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
    })
    @GetMapping("/users")
    public List<User> getUsers() throws InterruptedException {
        int executeTime = random.nextInt(200);
        System.out.println("Execute time: " + executeTime + " ms");
        if (executeTime > 100) {
            Thread.sleep(executeTime);
        }
        List<User> users = new LinkedList<>();
        users.add(new User(UUID.randomUUID().toString(), "张三"));
        return users;
    }

    public List<User> fallbackMethodForGetUsers() {
        return new LinkedList<>();
    }
}
