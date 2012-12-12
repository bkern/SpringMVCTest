package com.bkern.mvc.web.controller;

import com.bkern.mvc.domain.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class JSONController {

    @RequestMapping(value = {"/getData/{userId}"}, method = RequestMethod.GET, produces = "application/json")
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

}
