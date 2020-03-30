package com.ift.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制器
 *
 * @author liufei
 * @since 0.0.1
 */
@RestController
public class UserController {

    @GetMapping("/name")
    public Map<String, String> userinfo(HttpServletRequest request) {
        Map<String, String> result = new HashMap<>(2);
        result.put("username", "zhangsan");
        result.put("userSessionId", request.getSession().getId());
        return result;
    }

    @GetMapping("/date")
    public String date() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @GetMapping("/version")
    public String version() {
        return "Version 2.0";
    }
}
