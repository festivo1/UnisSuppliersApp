/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.controller;

import com.utsicom.webapp.model.Dipo;
import com.utsicom.webapp.model.Role;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.utsicom.webapp.model.User;
import com.utsicom.webapp.service.DipoService;
import com.utsicom.webapp.service.UserService;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@EnableAutoConfiguration
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private DipoService dipoService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
//        @RequestMapping(value="/registration", method = RequestMethod.GET)

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();//binding
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest request) {
        // Lookup user in database by e-mail
        //User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        User userExists = userService.findByEmail(user.getEmail());

        System.out.println(userExists);

        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("registration");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else { // new user so we create user and send confirmation e-mail

            // Disable user until they click on confirmation link in email
//		    user.setEnabled(false);
//		      
//		    // Generate random 36-character string token for confirmation link
//		    user.setConfirmationToken(UUID.randomUUID().toString());
            // PostDto postDto = modelMapper.map(post, PostDto.class);
            //Post post = modelMapper.map(postDto, Post.class);
           
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername());
        //user.setPhoto(user.getPhoto());
        Collection<Role> roles=new ArrayList<>();
        Role r= new Role("ROLE_USER");
        roles.add(r);
         user.setRoles(roles);
         userService.saveOrUpdate(user);
         //user.setDipo(new Dipo(user.getId()));
         Dipo dipo= new Dipo();
         int id=(user.getId());
            System.out.println(id);
         dipo.setId(id);
         dipo.setUser(new User(user.getId()));
         dipoService.saveOrUpdate(dipo);
         
         
         
            System.out.println("user save huna aairacha ");

        }
        //return "redirect:/login";
       return "redirect:/login";
    }
    
    
    
}
