package com.DB.course_work.serviceTest;

import com.DB.course_work.DAO.entities.Event;
import com.DB.course_work.DAO.entities.Location;
import com.DB.course_work.Service.Exceptions.ServiceException;
import com.DB.course_work.Service.ManagerService;
import com.DB.course_work.Service.impl.ManagerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManagerServiceTest {
    @Autowired
    private ManagerService managerService;

    @Test
    public void setSomeEvent(){
        try {
            Location location = new Location();
            location.setId(1);

            Event event = new Event();
            event.setName("event1");
            event.setLocation(location);
            event.setType("Test");

            managerService.setEvent(30, event);
        }catch (ServiceException e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }


}
