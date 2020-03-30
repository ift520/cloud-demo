package com.ift.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * 用户FeignClient
 *
 * @author liufei
 * @since 0.0.1
 */
@FeignClient(value = "user-service")
public interface UserFeignClient {

    @GetMapping("/name")
    Map<String, String> userinfo();
}
