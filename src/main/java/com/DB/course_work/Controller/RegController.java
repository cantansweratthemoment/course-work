package com.DB.course_work.Controller;

import com.DB.course_work.DAO.entities.Athlete;
import com.DB.course_work.DAO.entities.Users;
import com.DB.course_work.DAO.utils.JsonResult;
import com.DB.course_work.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class RegController extends BasicController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/reg/{login}/{password}/{role}/{realName}")
    /**
     * Example:
     * http://localhost:8080/users/reg/user0010/123456/0/Siyuan
     * */
    public JsonResult<Void> register(Users user, @PathVariable String realName) {
        Integer userId = registerService.BasicReg(user);
        registerService.regAsPerson(user, realName);

        if (user.getRole() == 1) registerAsSV(userId);
        return new JsonResult<>(OK);
    }

    @RequestMapping("/reg/athlete/{login}/{height}/{weight}/{nationality}/{sport}")
    /**
     * Example:
     * http://localhost:8080/users/reg/athlete/user0010/01/01/CN/Football
     * */
    public JsonResult<Void> registerAsAthlete(Athlete athlete, @PathVariable String login) {
        registerService.regAsAthlete(login, athlete);
        return new JsonResult<>(OK);
    }

    public void registerAsSV(Integer userId) {
        registerService.regAsSV(userId);
    }

//    @RequestMapping("/reg/{username}")
//    public JsonResult<Void> registerAsAthlete(String username, Person)


//    public JsonResult<Void> register(Users user){
//        JsonResult<Void> result = new JsonResult<>();
//        try {
//            registerService.BasicReg(user);
//            result.setState(200);
//            result.setMessage("Successfully register!");
//        }catch (UsernameDuplicatedException e){
//            result.setState(4000);
//            result.setMessage("Username has existed");
//        }catch (InsertException e){
//            result.setState(5000);
//            result.setMessage("Exception about insert user");
//        }
//
//        return result;
//    }
//    @GetMapping("/queryUserList")
//    public List<Users> queryUserList(){
//        List<Users> usersList = usersMapper.getAllUsers();
//        return usersList;
//    }

//    @PostMapping("/register/{username}/{password}")
//    public int createUser(@PathVariable Integer login, String password){
//
//    }

}
