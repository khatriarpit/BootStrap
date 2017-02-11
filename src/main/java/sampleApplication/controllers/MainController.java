package sampleApplication.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

  // inject via application.properties
  @Value("${welcome.message:test}")
  private String message = "Hello World";

  @RequestMapping("/")
  public String test(Map<String, Object> model) {
    model.put("message", this.message);
    return "test";
  }
  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public ModelAndView hello() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("test");

    String str = "Hello World!";
    mav.addObject("message", str);

    return mav;
  }


}
