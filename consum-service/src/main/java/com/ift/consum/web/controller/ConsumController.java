package com.ift.consum.web.controller;

import com.ift.consum.web.hystrix.ConsumHystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liufei
 * @since 2020/3/30
 */
@RestController
public class ConsumController {

    @GetMapping("/consum")
    public List consum() {
        RestTemplate restTemplate = new RestTemplate();
        return new ConsumHystrixCommand(restTemplate).execute();
    }
}
