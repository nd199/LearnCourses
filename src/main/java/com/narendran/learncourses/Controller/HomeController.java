package com.narendran.learncourses.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    ModelAndView modelAndView = new ModelAndView();


    @GetMapping("/home")
    public ModelAndView getHome() {
        LOGGER.info(" HomeController :  Home Page invoked");
        modelAndView.setViewName("index.html");
        return modelAndView;
    }


    @GetMapping("/providerLogin")
    public ModelAndView providerLogin() {
        LOGGER.info("Home Controller : provider login method invoked");
        modelAndView.setViewName("provider/providerLogin");
        return modelAndView;
    }

    @GetMapping("/learnerLogin")
    public ModelAndView learnerLogin() {
        LOGGER.info("Home Controller : learner login method invoked");
        modelAndView.setViewName("learner/learnerLogin");
        return modelAndView;
    }
}
