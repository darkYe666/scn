package cn.yejy.eureka_client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author ye
 * @date 2019-05-08
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/log1")
    public Object log1() {
        ConsoleUserVo userVo = AgentThreadLocal.get();
        return userVo;
    }

    @GetMapping("/login")
    public Object logni(@RequestParam String name, @RequestParam String id, HttpSession session) {
        ConsoleUserVo userVo = new ConsoleUserVo();
        userVo.setId(id);
        userVo.setName(name);
        session.setAttribute("userInfo", userVo);
        return userVo;
    }

}
