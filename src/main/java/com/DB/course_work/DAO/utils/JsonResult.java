package com.DB.course_work.DAO.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

// Send response as Json.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<E> implements Serializable {
    /** Status Code */
    private Integer state;

    private String message;

    private E data;

    public JsonResult(Integer state){
        this.state = state;
    }

    public JsonResult(Throwable e){
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data){
        this.state = state;
        this.data = data;
    }
}
