package sampleApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("/jsptest")
    public ModelAndView test() {

        return new ModelAndView("redirect:" + "/test");
    }

    @RequestMapping("/jtest")
    public ModelAndView testing() {

        return new ModelAndView( "/test");
    }
}

