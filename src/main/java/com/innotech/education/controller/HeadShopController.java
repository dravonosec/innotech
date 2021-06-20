package com.innotech.education.controller;


import com.innotech.education.entity.Head;
import com.innotech.education.entity.User;
import com.innotech.education.repository.HeadRepository;
import com.innotech.education.repository.UserRepository;
import com.innotech.education.service.CharacterService;
import com.innotech.education.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@RestController
public class HeadShopController {

    @Autowired
    private UserDetailsServiceImpl userService;
    @Autowired
    private HeadRepository headRepository;
    @Autowired
    private CharacterService characterService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/{userId}/head_shop")
    public ModelAndView viewHatShop() {

//        File folder = new File("C:\\My_Files\\Spring_work\\col_version\\src\\main\\resources\\static\\img\\Hats");
//        File[] listOfFiles = folder.listFiles();

        ModelAndView mav = new ModelAndView("head_shop");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            // возможно не будет работать с авторизацией из соц сети
        }
        else username = null;

        User user = userService.getUser(username);

        List<Head> heads = headRepository.getHeadsByCharacterId(user.getCharacter().getId());
        mav.addObject("heads", heads);
        mav.addObject("userId", user.getId());

        return mav;
    }

    @RequestMapping("/{userId}/head_shop/{headId}/save")
    public String setHat(@PathVariable(name = "userId") Long userId,
                         @PathVariable(name = "headId") Long headId, Model model) {

        ModelAndView mav = new ModelAndView("head_shop");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            // возможно не будет работать с авторизацией из соц сети
        }
        else username = null;
        userRepository.getUserByUsername(username).getCharacter().getHead().setId(headId);

        return "redirect:/" + "login";
    }
}
