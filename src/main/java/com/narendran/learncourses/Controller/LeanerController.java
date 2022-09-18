package com.narendran.learncourses.Controller;

import com.narendran.learncourses.Entity.Course;
import com.narendran.learncourses.Entity.Learner;
import com.narendran.learncourses.Exception.ResourceNotFoundException;
import com.narendran.learncourses.Service.CourseService;
import com.narendran.learncourses.Service.LearnerService;
import com.narendran.learncourses.utility.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LeanerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeanerController.class);
    ModelAndView modelAndView = new ModelAndView();

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private LearnerService learnerService;


    @Autowired
    private CourseService courseService;

    @GetMapping("/showLearnerReg")
    public ModelAndView learnerRegistrationPage() {
        LOGGER.info("LEARNER CONTROLLER : InsideShowRegistrationPage");
        modelAndView.addObject("message", "");
        modelAndView.setViewName("learner/learnerReg");
        return modelAndView;
    }

    @PostMapping("/learnerReg")
    public ModelAndView registerLearner(Learner learner,
                                        String password,
                                        String confirmPassword) {
        LOGGER.info(" LEARNER CONTROLLER : Learner registration()" + learner);
        try {
            if(password.equals(confirmPassword)) {
                modelAndView.addObject(learnerService.addLearner(learner));
                emailUtil.sendEmail(learner.getEmail(), "noReply : " +
                                "WELCOME TO LEARN COURSES " + learner.getFirstName(),
                        "Hello " + learner.getFirstName() +
                                " YOUR CREDENTIALS : " + "\nYour email address : " + learner.getEmail() +
                                "\nYour Password : " + learner.getPassword() + "\nPlease Dont Share With anyone!");
                modelAndView.setViewName("learner/learnerLogin");
            }
            else {
                modelAndView.addObject("message", "Passwords Do Not match");
                modelAndView.setViewName("learner/learnerReg");
            }
        }catch (Exception e) {
            modelAndView.addObject("regmessage", "Learner already exist, please try Login");
            modelAndView.setViewName("learner/learnerReg");
            emailUtil.sendEmail(learner.getEmail(), "noReply : " +
                            "WELCOME TO LEARN COURSES " + learner.getFirstName(),
                    "Seems like u r already registered with LEARN COURSES Try Login " );
        }
        return modelAndView;
    }


    @GetMapping("/learnerLoginPage")
    public ModelAndView learnerLoginPage() {
        LOGGER.info("LEARNER CONTROLLER : Inside showLoginPage()");
        modelAndView.addObject("message", "");
        modelAndView.setViewName("learner/learnerLogin");
        return modelAndView;
    }


    @PostMapping("/loginLearner")
    public ModelAndView loginLearner(String emailAddress, String password, String confirmPassword) {
        LOGGER.info(" LEARNER CONTROLLER : Inside loginLearner()");
        Learner learner = null;
        try {
            learner = learnerService.findLearnerByEmailAndPasswordAndConfirmPassword(emailAddress, password
            ,confirmPassword
            );
        } catch (ResourceNotFoundException re) {
            re.printStackTrace();
        }
        if (learner != null && learner.getPassword().equals(password)
        && learner.getPassword().equals(confirmPassword)) {
            List<Course> courses = courseService.getCourses();
            modelAndView.addObject("courses", courses);
            modelAndView.setViewName("course/coursesListforLearners");
            emailUtil.sendEmail(learner.getEmail(), "LOGGED IN SUCCESSFUL",
                    " WELCOME " + learner.getLastName() + "\nSEEMS YOU GOT IN " +
                            "UPGRADE YOUR SKILLS HERE \n " +
                            "Have a great day");
        } else {
            modelAndView.addObject("message", "Invalid learnername or Password");
            modelAndView.setViewName("learner/learnerLogin");
        }
        return modelAndView;
    }

    @GetMapping("/learners")
    public ModelAndView getAllLearners() {
        LOGGER.info(" LEARNER CONTROLLER : Getting all learners()");
        List<Learner> learners = learnerService.getAllLearners();
        modelAndView.addObject("learners", learners);
        modelAndView.setViewName("learner/learnersList");
        return modelAndView;
    }

}
