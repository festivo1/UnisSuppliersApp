///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.utsicom.webapp.controller.admin;
//
//import com.utsicom.webapp.dto.DipoDTO;
//import com.utsicom.webapp.model.Dipo;
//import com.utsicom.webapp.model.User;
//import com.utsicom.webapp.repository.DipoRepository;
//import com.utsicom.webapp.service.DipoService;
//import com.utsicom.webapp.service.ItemService;
//import com.utsicom.webapp.service.SupplierService;
//import com.utsicom.webapp.service.UserService;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// *
// * @author utsi
// */
//@Controller
//@RequestMapping(value = "admin/dipos")
//public class DipoController {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private DipoService dipoService;
//    @Autowired
//    private SupplierService supplierService;
//    @Autowired
//    private ItemService itemService;
//    @Autowired
//    private DipoRepository dipoRepo;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String index(Model model, @RequestParam(defaultValue = "0") int page) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findByEmail(auth.getName());
//        System.out.println(userService.findByEmail(auth.getName()));
//        model.addAttribute("userName", "Welcome " + user.getFirstName());
//        int id = user.getId();
//        System.out.println(id);
//        //model.addAttribute("user", userService.findByEmail(String email));
//         model.addAttribute("dipos", dipoRepo.findAll(PageRequest.of(page, 9)));//(PageRequest(page, 5)));
////        if (dipoService.getById(id).isPresent()) {
////            model.addAttribute("dipo", dipoService.getById(id));
////        }
//       // model.addAttribute("dipo", dipoService.getById(id));
//        model.addAttribute("currentPage", page);
//        model.addAttribute("suppliers", supplierService.getAll());
//        model.addAttribute("items", itemService.getAll());
//        System.out.println(itemService.getAll());
//        // model.addAttribute("dipos",dipoService.getAll(PageRequest.of(page, 9));
//        System.out.println(user.getFirstName());
//        // return "admin_shared/fragments";
//        return "admin/dipos/index";
//    }
//
//    @RequestMapping(value = "/create")
//    public String create(Model model) {
//        model.addAttribute("user", userService.getAll());
//        model.addAttribute("dipos", dipoService.getAll());
//
//        return "admin/dipos/create";
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String save(DipoDTO dipoDTO) {
//        Dipo dipo = new Dipo();
//        dipo.setId(dipoDTO.getId());
//        dipo.setName(dipoDTO.getName());
//        dipo.setAddress(dipoDTO.getAddress());
//        dipo.setContactNumber(dipoDTO.getContactNumber());
//        dipo.setPanNumber(dipoDTO.getPanNumber());
//        dipo.setAddedDate(new Date());
//        //dipo.setUser(new User(dipoDTO.getUsername()));
//        //User user = new User();
//        //user.setUsername(dipoDTO.getUsername());
//        //user.setPassword(dipoDTO.getPassword());
//        //user.setId(dipoDTO.getUid());
//        dipoService.saveOrUpdate(dipo);
//        return "redirect:/dipos";
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    //@DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable(required = true, name = "id") int id) {
//        dipoService.delete(id);
//        return "redirect:/dipos";
//    }
//
//    @GetMapping(value = "/edit/{id}")
//    @ResponseBody
//    public Optional<Dipo> findOne(@PathVariable(required = true, name = "id") int id, Model model) {
//
//        
//        model.addAttribute("dipos",dipoService.getById(id));
//        return dipoService.getById(id);
//    }
//}
