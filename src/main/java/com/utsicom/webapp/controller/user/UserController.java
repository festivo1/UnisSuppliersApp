///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// *
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.utsicom.webapp.controller.user;

import com.utsicom.webapp.dto.DipoDTO;
import com.utsicom.webapp.model.AmountDeposited;
import com.utsicom.webapp.model.Dipo;
import com.utsicom.webapp.model.User;
import com.utsicom.webapp.repository.DipoRepository;
import com.utsicom.webapp.repository.LeakageRepository;
import com.utsicom.webapp.service.AmountDepositedService;
import com.utsicom.webapp.service.DipoService;
import com.utsicom.webapp.service.ItemDepositedService;
import com.utsicom.webapp.service.ItemService;
import com.utsicom.webapp.service.LeakageService;
import com.utsicom.webapp.service.SupplierService;
import com.utsicom.webapp.service.TransactionService;
import com.utsicom.webapp.service.UserService;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author utsi
 */
@Controller
//@PreAuthorize("hasAuthority('ADMIN_ROLE')")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DipoService dipoService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private DipoRepository dipoRepo;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private LeakageService leakageService;
    @Autowired
    private AmountDepositedService amountDepositedService;
    @Autowired
    private ItemDepositedService itemDepositedService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println(userService.findByEmail(auth.getName()));
        model.addAttribute("userName", "Welcome " + user.getFirstName());
        int id = user.getId();
        System.out.println(id);
       
        //model.addAttribute("user", userService.findByEmail(String email));
        if (dipoService.getById(id).isPresent()) {
            Optional<Dipo> dipo = dipoService.getById(id);
            //model.addAttribute("dipo",dipoService.getById(id));
            model.addAttribute("dipoName", dipo.get().getName());//(PageRequest(page, 5)));
            model.addAttribute("dipoId", dipo.get().getId());
            model.addAttribute("dipoAddress", dipo.get().getAddress());
            model.addAttribute("dipoContact", dipo.get().getContactNumber());
            model.addAttribute("dipoPan", dipo.get().getPanNumber());
            model.addAttribute("dipoAddedDate", dipo.get().getAddedDate());

            System.out.println(dipo.get().getId());
        }
        return "user/index";
        // return "user/report/dipoReport";
    }

    @RequestMapping(value = "dipo/save", method = RequestMethod.POST)
    public String save(DipoDTO dipoDTO, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println(userService.findByEmail(auth.getName()));
        model.addAttribute("userName", "Welcome " + user.getFirstName());
        int id = user.getId();
        Dipo dipo = new Dipo();
        dipo.setId(dipoDTO.getId());
        dipo.setUser(new User(dipo.getId()));
        dipo.setName(dipoDTO.getName());
        dipo.setAddress(dipoDTO.getAddress());
        dipo.setContactNumber(dipoDTO.getContactNumber());
        dipo.setPanNumber(dipoDTO.getPanNumber());
        dipo.setAddedDate(new Date());
        //dipo.setUser(new User(dipoDTO.getUsername()));
        //User user = new User();
        //user.setUsername(dipoDTO.getUsername());
        //user.setPassword(dipoDTO.getPassword());
        //user.setId(dipoDTO.getUid());
        dipoService.saveOrUpdate(dipo);
        return "redirect:/user";
    }

    @GetMapping(value = "/dipo/edit/{id}")
    @ResponseBody
    public Optional<Dipo> findOne(@PathVariable(required = true, name = "id") int id, Model model) {

        //model.addAttribute("dipos",dipoService.getById(id));
        return dipoService.getById(id);
    }

    @RequestMapping(value = "/transactions/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public String transactionDetails(@PathVariable("id") int id, Model model, ModelMap map) {

//        model.addAttribute("items", itemService.getAll());
//        model.addAttribute("suppliers", supplierService.getAll());
//        model.addAttribute("dipos", dipoService.getAll());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println(userService.findByEmail(auth.getName()));
        //model.addAttribute("userName", "Welcome " + user.getFirstName());
        Optional<Dipo> dipo = dipoService.getById(id);
        model.addAttribute("dipoName", dipo.get().getName());
        System.out.println(dipo.get().getName());
        model.addAttribute("transactions", transactionService.findAllByDipoId(id));
        //model.addAttribute("transactions", transactionService.getAll());
        System.out.println(transactionService.findAllByDipoId(id));
        if (user.getId() == id) {
            return "user/transactions/index";

        } else {
            return null;
        }
        //return transactionService.findAllByDipoId(id);
    }

    @RequestMapping(value = "/leakage/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public String leakageDetails(@PathVariable("id") int id, Model model, ModelMap map) {

//        model.addAttribute("items", itemService.getAll());
//        model.addAttribute("suppliers", supplierService.getAll());
//        model.addAttribute("dipos", dipoService.getAll());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println(userService.findByEmail(auth.getName()));
        model.addAttribute("userName", "Welcome " + user.getFirstName());
        Optional<Dipo> dipo = dipoService.getById(id);
        model.addAttribute("dipoName", dipo.get().getName());
        System.out.println(dipo.get().getName());
        //model.addAttribute("leakage",leakageService.findAllById(id));
        //model.addAttribute("transactions", transactionService.findAllByDipoId(id));
        //model.addAttribute("transactions", transactionService.getAll());
        //System.out.println(transactionService.findAllByDipoId(id));
        model.addAttribute("leakages", leakageService.findAllByDipoId(id));
        if (user.getId() == id) {
            return "user/leakage/report";

        } else {
            return null;
        }
        //return transactionService.findAllByDipoId(id);
    }

    @RequestMapping(value = "/depositedAmount/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public String amountDetails(@PathVariable("id") int id, Model model, ModelMap map) {

//        model.addAttribute("items", itemService.getAll());
//        model.addAttribute("suppliers", supplierService.getAll());
//        model.addAttribute("dipos", dipoService.getAll());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println(userService.findByEmail(auth.getName()));
        model.addAttribute("userName", "Welcome " + user.getFirstName());
        Optional<Dipo> dipo = dipoService.getById(id);
        model.addAttribute("dipoName", dipo.get().getName());
        System.out.println(dipo.get().getName());
        //model.addAttribute("leakage",leakageService.findAllById(id));
        //model.addAttribute("transactions", transactionService.findAllByDipoId(id));
        //model.addAttribute("transactions", transactionService.getAll());
        //System.out.println(transactionService.findAllByDipoId(id));
        model.addAttribute("amountDeposits", amountDepositedService.findAllByDipoId(id));
        if (user.getId() == id) {
            return "user/depositedAmt/report";

        } else {
            return null;
        }
        //return transactionService.findAllByDipoId(id);
    }

    @RequestMapping(value = "/depositedCylinder/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public String cylinderDetails(@PathVariable("id") int id, Model model, ModelMap map) {

//        model.addAttribute("items", itemService.getAll());
//        model.addAttribute("suppliers", supplierService.getAll());
//        model.addAttribute("dipos", dipoService.getAll());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println(userService.findByEmail(auth.getName()));
        model.addAttribute("userName", "Welcome " + user.getFirstName());
        Optional<Dipo> dipo = dipoService.getById(id);
        model.addAttribute("dipoName", dipo.get().getName());
        System.out.println(dipo.get().getName());
        //model.addAttribute("leakage",leakageService.findAllById(id));
        //model.addAttribute("transactions", transactionService.findAllByDipoId(id));
        //model.addAttribute("transactions", transactionService.getAll());
        //System.out.println(transactionService.findAllByDipoId(id));
        model.addAttribute("itemDeposits", itemDepositedService.findAllByDipoId(id));
        if (user.getId() == id) {
            return "user/depositedCyl/report";

        } else {
            return null;
        }
        //return transactionService.findAllByDipoId(id);
    }

}
