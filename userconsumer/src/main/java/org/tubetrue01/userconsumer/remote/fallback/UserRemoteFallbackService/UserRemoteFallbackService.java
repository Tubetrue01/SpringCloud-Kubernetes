package org.tubetrue01.userconsumer.remote.fallback.UserRemoteFallbackService;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.tubetrue01.pojo.User;
import org.tubetrue01.userconsumer.remote.UserRemoteService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/2/11
 * Time : 12:41 下午
 * Description :
 */
@Log4j2
@Component
public class UserRemoteFallbackService implements UserRemoteService {
    @Override
    public List<User> findAll() {
        log.warn("-==获取用户信息服务进入了降级状态！==-");
        return List.of(new User(404,"Error", "Error"));
    }

    @Override
    public void save(User user) {
        log.warn("-==保存用户信息服务进入降级[{}]==-", user.getUsername());
    }
}
