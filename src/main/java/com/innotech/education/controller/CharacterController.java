package com.innotech.education.controller;

import com.innotech.education.entity.Character;
import com.innotech.education.entity.User;
import com.innotech.education.repository.UserRepository;
import com.innotech.education.service.CharacterService;
import com.innotech.education.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class CharacterController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/character", method = RequestMethod.GET)
    public ModelAndView character() {
        ModelAndView mav = new ModelAndView("character");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            // возможно не будет работать с авторизацией из соц сети
        }
        else username = null;

        User user = userDetailsService.getUser(username);

        mav.addObject("user", user);
        return mav;
    }
}
