package com.narendran.learncourses.Controller;


import com.narendran.learncourses.Entity.Provider;
import com.narendran.learncourses.Exception.ResourceNotFoundException;
import com.narendran.learncourses.Service.ProviderService;
import com.narendran.learncourses.utility.EmailUtil;
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
    private EmailUtil emailUtil;
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
    public ModelAndView registerProvider(Provider provider ,
                                         String password ,
                                         String confirmPassword) {
        LOGGER.info("PROVIDER CONTROLLER : InsideRegister()" + provider);
        try {
            if(password.equals(confirmPassword)) {
                modelAndView.addObject(providerService.addProvider(provider));
                emailUtil.sendEmail(provider.getEmail(), "noReply : " +
                                "WELCOME TO LEARN COURSES" + provider.getFirstName(),
                        "Hello " + provider.getFirstName() +
                                " YOUR CREDENTIALS : " + "\nYour email address : " + provider.getEmail() +
                                "\nYour Password : " + provider.getPassword() + "\nPlease Dont Share With anyone!");
                modelAndView.setViewName("provider/providerLogin");
            }
            else {
                modelAndView.addObject("message", "Passwords Do Not match");
                modelAndView.setViewName("provider/providerReg");
            }
        } catch (Exception e) {
            modelAndView.addObject("message", "Provider already exist, please try Login");
            modelAndView.setViewName("provider/providerReg");
            emailUtil.sendEmail(provider.getEmail(), "noReply : " +
                            "WELCOME TO LEARN COURSES" + provider.getFirstName(),
                    "Seems like u r already registered with LEARN COURSES Try Login " );
        }
        return modelAndView;
    }

    @GetMapping("/loginProviderPage")
    public ModelAndView showLoginPage() {
        LOGGER.info("PROVIDER CONTROLLER : Inside showLoginPage()");
        modelAndView.addObject("message", "");
        modelAndView.setViewName("provider/providerLogin");
        return modelAndView;
    }


    @PostMapping("/loginProvider")
    public ModelAndView loginProvider(String email, String password,String confirmPassword) {
        LOGGER.info("PROVIDER CONTROLLER : Inside loginProvider()");
        Provider provider = null;
        try {
            provider = providerService.findProviderByEmailAddressAndPasswordAndConfirmPassword
                    (email, password,confirmPassword);
        } catch (ResourceNotFoundException re) {
            re.printStackTrace();
        }
        if (provider != null && provider.getPassword().equals(password)
                && provider.getPassword().equals(confirmPassword)) {
            modelAndView.addObject("message", "");
            modelAndView.setViewName("provider/provider_dashboard");
                emailUtil.sendEmail(provider.getEmail(),"LOGGED IN SUCCESSFUL","\n" +
                        "Have a great day");
        } else {
            modelAndView.addObject("message", "Invalid Username or Password");
            modelAndView.setViewName("provider/providerLogin");
        }
        return modelAndView;
    }

    @GetMapping("/providerDashboard")
    public ModelAndView getProviderDashboard() {
        modelAndView.setViewName("provider/provider_dashboard");
        return modelAndView;
    }
}



