package com.narendran.learncourses.Controller;


import com.narendran.learncourses.Entity.Provider;
import com.narendran.learncourses.Service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProviderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderController.class);
    ModelAndView modelAndView = new ModelAndView();


    @Autowired
    private ProviderService providerService;


    @GetMapping("/providerRegPage")
    public ModelAndView registrationPage() {
        LOGGER.info("PROVIDER CONTROLLER : InsideShowRegistrationPage");
        modelAndView.addObject("message", "");
        modelAndView.setViewName("provider/providerReg");
        return modelAndView;
    }

    @PostMapping("/providerReg")
    public ModelAndView registerProvider(Provider provider) {
        LOGGER.info("PROVIDER CONTROLLER : InsideRegister()" + provider);
        try {
            modelAndView.addObject(providerService.addProvider(provider));
            modelAndView.setViewName("provider/providerLogin");
        } catch (Exception e) {
            modelAndView.addObject("message", "Provider already exist, please try Login");
            modelAndView.setViewName("provider/providerReg");
        }
        return modelAndView;
    }
}



