package com.bkern.mvc.web.controller;

import com.bkern.mvc.domain.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class JSONController {

    @RequestMapping(value = {"/getData/{userId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserData getData(@PathVariable("userId") String userId) throws Exception {

        UserData ud = new UserData();
        ud.setAge(99);
        ud.setName("wayne");
        ud.setSampleData("this is some sample data");
        ud.setCount(34);
        ud.setRole(UserData.USER_ROLES.USER);
        return ud;
    }

    @RequestMapping(value = {"/user/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String saveUser(@RequestBody UserData userData,HttpServletResponse response) throws Exception {

        if(userData.getAge() > 40){
            //fake error
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return "error";
        }
         else if (userData.getAge()>30){
            //fake some security check failed
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return "forbidden";
        }
        else {
            //fake save
            response.setStatus(HttpStatus.OK.value());
            return "success";
        }
    }
}
