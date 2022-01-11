package com.DB.course_work.Controller;


import com.DB.course_work.DAO.entities.Building;
import com.DB.course_work.DAO.entities.Location;
import com.DB.course_work.DAO.utils.JsonResult;
import com.DB.course_work.Service.LocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.DB.course_work.Controller.BasicController.OK;

@RestController
@RequestMapping("loc")
public class LocController {

    @Autowired
    private LocService locService;

    @RequestMapping("/getAllLoc")
    /**
     * Example: http://localhost:8080/loc/getAllLoc
     */ public JsonResult<List<Location>> getAllLocInfo() {
        return new JsonResult<>(OK, locService.findAllLocInfo());
    }

    @RequestMapping("/{LocId}/buildings")
    public JsonResult<List<Building>> getBuildingsByLocId(@PathVariable Integer LocId) {
         List<Building> result = locService.findBuildingsByLocId(LocId);
         return new JsonResult<>(OK, result);
    }


}
