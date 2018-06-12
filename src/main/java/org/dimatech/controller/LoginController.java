package org.dimatech.controller;

import org.dimatech.model.User;
import org.dimatech.service.EmailService;
import org.dimatech.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

@Controller
public class LoginController {

   // private BCryptPasswordEncoder bCryptPasswordEncoder;
  //  private UserService userService;
  //  private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

//    @Autowired
//    private UserService userService;


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

/*
        if (userExists == null) {
            modelAndView.setViewName("login");
            modelAndView.addObject("badCredentials", "Bad credentials!");
            logger.debug("Login successfull!");
            return modelAndView;
        //Login failed
        }else{
            logger.debug("Login failed!");

        }


*/



    }



