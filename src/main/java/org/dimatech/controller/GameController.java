package org.dimatech.controller;

import org.dimatech.model.User;
import org.dimatech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

    @Autowired
    public GameController() {

    }

    @RequestMapping(value = {"/", "/game"}, method = RequestMethod.GET)
    public ModelAndView showMainPage(ModelAndView modelAndView) {
        modelAndView.setViewName("game");
        return modelAndView;
    }
}
