package com.baobaotao.service;

import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.dao.UserDao;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Static
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user) throws Exception {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insert(loginLog);
    }

    public void update(User user) throws Exception {
        user.setCredits(5 + user.getCredits());
        userDao.updateLoginInfo(user);
    }

    public int insert(String userName, String password) {
        return userDao.insert(userName, password);
    }

    @Transactional(rollbackFor = Exception.class)
    public void test(String userName, String password) throws Exception {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        int id = this.insert(user.getUserName(), user.getPassword());
        System.out.println(id);
        user.setUserId(id);
        user.setLastVisit(new Date());
        user.setLastIp("192.168.2.1");
        user.setCredits(10);
        this.update(user);
    }
}