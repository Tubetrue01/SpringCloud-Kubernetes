package org.tubetrue01.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/3/16
 * Time : 10:45 上午
 * Description :
 */
@RestController
@RequestMapping("/gateway")
public class FallbackController {

    @GetMapping("/fallback")
    public String fallbackA() {
        return "服务暂时不可用";
    }
}
