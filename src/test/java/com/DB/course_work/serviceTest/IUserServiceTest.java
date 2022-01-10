package com.DB.course_work.serviceTest;

import com.DB.course_work.Service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpSession;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserServiceTest {
    @Autowired
    private IUserService IUserService;

    @Test
    public void login(){
//        System.out.println(registerService.login("user0019", "123456"));
    }

}
