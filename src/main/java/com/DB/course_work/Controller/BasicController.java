package com.DB.course_work.Controller;

import com.DB.course_work.DAO.utils.JsonResult;
import com.DB.course_work.Service.Exceptions.InsertException;
import com.DB.course_work.Service.Exceptions.PasswordNotMatchException;
import com.DB.course_work.Service.Exceptions.UserNotFoundException;
import com.DB.course_work.Service.Exceptions.UsernameDuplicatedException;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

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
        }else if (e instanceof PasswordNotMatchException){
            result.setState(5001);
            result.setMessage("Wrong login or passwords.");
        }else if (e instanceof UserNotFoundException){
            result.setState(5002);
            result.setMessage("Have not registered yet.");
        }
        return result;
    }


    /** Get the uid from session
     * @param session session object
     * @return recent user's id
     */
    protected final Integer getuidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
    /** Get the username from session
     * @param session session object
     * @return recent user's username
     */
    protected final String getUserNameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
