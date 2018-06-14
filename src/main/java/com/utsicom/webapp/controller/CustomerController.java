///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.utsicom.webapp.controller;
//
//import com.utsicom.webapp.model.User;
//import com.utsicom.webapp.service.DipoService;
//import com.utsicom.webapp.service.ItemService;
//import com.utsicom.webapp.service.SupplierService;
//import com.utsicom.webapp.service.TransactionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import com.utsicom.webapp.service.UserService;
//
///**
// *
// * @author utsi
// */
//@Controller
//@RequestMapping(value = "/customer")
//
//public class CustomerController {
//
//    @Autowired
//    TransactionService transactionService;
//    @Autowired
//    ItemService itemService;
//    @Autowired
//    SupplierService supplierService;
//    @Autowired
//    DipoService dipoService;
//    @Autowired
//    UserService userService;
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findByEmail(auth.getName());
//        System.out.println(userService.findByEmail(auth.getName()));
//        modelAndView.addObject("userName", "Welcome " + user.getFirstName());
//        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("/customers/index");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "report/{id}", method = RequestMethod.GET)
//    public String transactionDetails(@PathVariable int id, Model model, ModelMap map) {
//        model.addAttribute("items", itemService.getAll());
//        model.addAttribute("suppliers", supplierService.getAll());
//        model.addAttribute("dipo", dipoService.getById(id));
//       // model.addAttribute("transactions", transactionDAO.findAllByDipo(id));
//        //transactionDAO.createViewById(id);
//        //model.addAttribute("reports", reportDAO.getAll());
//        //System.out.println(transactionDAO.findAllByDipo(id));
//        return "/customers/transaction_details";
//    }
//}
