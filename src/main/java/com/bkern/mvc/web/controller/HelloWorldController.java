package com.bkern.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloWorldController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request,HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("message","hello world from spring 3.2.RC2");
        return new ModelAndView("main",model);
    }
}
