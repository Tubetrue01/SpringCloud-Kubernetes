package org.tubetrue01.userconsumer.controller;

import com.netflix.discovery.DiscoveryManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/2/11
 * Time : 4:18 下午
 * Description :
 */
@Log4j2
@RestController
@RequestMapping("/eureka")
public class EurekaController {
    @GetMapping("/offline")
    public void offLine() {
        log.warn("-==注销服务:[{}]==-", System.getenv("POD_NAME"));
        DiscoveryManager.getInstance().shutdownComponent();
    }
}
