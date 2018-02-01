package com.yl;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/webapp/WEB-INF/applicationContext.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User user = userService.findUserByUserName("admin");
//        System.out.println(user);
    }

    @Test
    public void testTrans() throws Exception {
        userService.test("test3", "test3");
    }
}