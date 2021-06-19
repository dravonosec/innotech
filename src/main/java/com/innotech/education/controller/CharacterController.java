package com.innotech.education.controller;

import com.innotech.education.entity.Character;
import com.innotech.education.service.CharacterService;
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
    private CharacterService characterService;

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
