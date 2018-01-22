package com.baobaotao.controller;

import com.baobaotao.domain.TestA;
import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
import com.baobaotao.web.LoginCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Static
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private TestA testA;

    private Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String loginPage() {
        logger.info("登录页面+info");
        logger.error("登录页面+error");
        logger.debug("登录页面+debug");
        logger.warn("登录页面+warn");
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html", method = RequestMethod.POST)
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) throws Exception {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if (!isValidUser) {
            return new ModelAndView("login", "error", "用户名或密码错误");
        }
        User user = userService.findUserByUserName(loginCommand.getUserName());
        user.setLastIp(request.getLocalAddr());
        user.setLastVisit(new Date());
        userService.loginSuccess(user);
        request.getSession().setAttribute("user", user);
        return new ModelAndView("main");
    }
}