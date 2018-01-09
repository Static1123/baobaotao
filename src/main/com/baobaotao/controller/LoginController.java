package com.baobaotao.controller;

import com.baobaotao.domain.TestA;
import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
import com.baobaotao.web.LoginCommand;
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

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String loginPage() {
        testA.print();
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