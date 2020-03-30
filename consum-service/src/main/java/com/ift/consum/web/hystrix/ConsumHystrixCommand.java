package com.ift.consum.web.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

/**
 * 消费方熔断
 *
 * @author liufei
 * @since 0.0.1
 */
public class ConsumHystrixCommand extends HystrixCommand<List> {

    private RestTemplate restTemplate;

    public ConsumHystrixCommand(RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey("provider-service"),
                100);
        this.restTemplate = restTemplate;
    }

    @Override
    protected List run() throws Exception {
        return restTemplate.getForObject("http://localhost:8100/users", List.class);
    }

    @Override
    protected List getFallback() {
        return new LinkedList();
    }
}
