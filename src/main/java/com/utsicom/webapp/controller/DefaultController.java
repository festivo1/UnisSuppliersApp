/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author utsi
 */
@Controller
public class DefaultController {
    @RequestMapping(value="/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("USER")) {
            return "redirect:/user/";
        }
        System.out.println(request.isUserInRole("USER"));
        return "redirect:/admin/";
    }


}
