package com.DB.course_work.Controller;

import com.DB.course_work.DAO.utils.JsonResult;
import com.DB.course_work.Service.Exceptions.InsertException;
import com.DB.course_work.Service.Exceptions.UsernameDuplicatedException;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Basic of controllers
public class BasicController {
    // Successful operation.
    public static final int OK = 200;

    // Will handle exceptions and send info to frontend.
    @ExceptionHandler
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("Username has existed.");
        }else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("Problem about INSERT.");
        }
        return result;
    }
}
