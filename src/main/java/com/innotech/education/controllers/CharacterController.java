package com.innotech.education.controllers;

import com.innotech.education.models.Character;
import com.innotech.education.services.CharacterService;
import com.innotech.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private UserService userService;

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

        Character chr = characterService.getCharacter(username);
        mav.addObject("head", chr.getHead());
        mav.addObject("body", chr.getBody());
        mav.addObject("legs", chr.getLegs());
        return mav;
    }
}
