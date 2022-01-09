package com.DB.course_work.serviceTest;

import com.DB.course_work.DAO.entities.Users;
import com.DB.course_work.Service.Exceptions.ServiceException;
import com.DB.course_work.Service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private RegisterService userService;

    @Test
    public void reg() {
        try {
            Users users = new Users();
            users.setLogin("XingDe!!??");
            users.setPassword("123");
            users.setRole(-1);

            userService.BasicReg(users);
            System.out.println("OK");
        }catch (ServiceException e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }

}
