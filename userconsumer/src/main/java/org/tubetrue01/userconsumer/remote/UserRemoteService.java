package org.tubetrue01.userconsumer.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tubetrue01.pojo.User;
import org.tubetrue01.userconsumer.remote.fallback.UserRemoteFallbackService.UserRemoteFallbackService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/2/11
 * Time : 12:39 下午
 * Description :
 */
@Primary
@FeignClient(name = "user-provider", path = "/userprovider/user", fallback = UserRemoteFallbackService.class)
public interface UserRemoteService {

    @GetMapping("/info")
    List<User> findAll();

    @PostMapping("/save")
    void save(@RequestBody User user);
}
