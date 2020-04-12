package com.ift.order.controller;

import com.ift.order.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 订单接口
 *
 * @author liufei
 * @since 0.0.1
 */
@RestController
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/test")
    public Map<String, String> ordered(HttpServletRequest request) {
        Map<String, String> result = userFeignClient.userinfo();
        result.put("orderId", UUID.randomUUID().toString());
        result.put("orderSessionId", request.getSession().getId());
        return result;
    }

    @GetMapping("/date")
    public String date() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @GetMapping("/version")
    public String version() {
        return "Version 1.0";
    }
}
