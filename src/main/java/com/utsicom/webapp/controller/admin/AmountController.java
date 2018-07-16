/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.controller.admin;
    
  

import com.utsicom.webapp.dto.AmountDepositedDTO;
import com.utsicom.webapp.dto.DipoDTO;
import com.utsicom.webapp.model.AmountDeposited;
import com.utsicom.webapp.model.Dipo;
import com.utsicom.webapp.model.User;
import com.utsicom.webapp.repository.DipoRepository;
import com.utsicom.webapp.service.AmountDepositedService;
import com.utsicom.webapp.service.DipoService;
import com.utsicom.webapp.service.ItemService;
import com.utsicom.webapp.service.SupplierService;
import com.utsicom.webapp.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
@RequestMapping(value = "/admin/depositedAmount")
public class AmountController {

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
    private AmountDepositedService amountDepositedService;
   // @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println(userService.findByEmail(auth.getName()));
        model.addAttribute("userName", "Welcome " + user.getFirstName());
        int id = user.getId();
        System.out.println(id);
        model.addAttribute("amountdeposits",amountDepositedService.getAll());
        return "admin/depositedAmt/index";
       // return amountDepositedService.getAll();
        
    }

@RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Dipo> create(@PathVariable("id") int id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println(userService.findByEmail(auth.getName()));
        model.addAttribute("userName", "Welcome " + user.getFirstName());

        //model.addAttribute("transactions", transactionService.getAll());
        model.addAttribute("suppliers", supplierService.getAll());

        System.out.println(dipoService.getById(id));
        model.addAttribute("dipo", dipoService.getById(id));
        model.addAttribute("items", itemService.getAll());
        //return "admin/transactions/create";
        return dipoService.getById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(AmountDepositedDTO amountDepositedDTO) throws ParseException {
       AmountDeposited amountDeposited = new AmountDeposited();
       // dipo.setId(dipoDTO.getId());
        amountDeposited.setId(amountDepositedDTO.getId());
        amountDeposited.setDipo(new Dipo(amountDepositedDTO.getDid()));
        amountDeposited.setDepositedAmount(amountDepositedDTO.getAmountDeposited());
        amountDeposited.setDecrementedAmount(amountDepositedDTO.getDecrementedAmount());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(amountDepositedDTO.getAddedDate());
        amountDeposited.setAddedDate(date);
        amountDepositedService.saveOrUpdate(amountDeposited);
        return "redirect:/admin/";
    }

    @RequestMapping(value = "dipos/delete/{id}", method = RequestMethod.GET)
    //@DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(required = true, name = "id") int id) {
        dipoService.delete(id);
        return "redirect:/admin/dipos";
    }

    @GetMapping(value = "/dipos/edit/{id}")
    @ResponseBody
    public Optional<Dipo> findOne(@PathVariable(required = true, name = "id") int id, Model model) {

        
        model.addAttribute("dipos",dipoService.getById(id));
        return dipoService.getById(id);
    }
    
    
     @RequestMapping(value = "/report/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public String amountDetails(@PathVariable("id") int id, Model model, ModelMap map) {

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
        //model.addAttribute("suppliers", transactionService.findAllByDipoId(id));
        //model.addAttribute("transactions", transactionService.getAll());
        //System.out.println(transactionService.findAllByDipoId(id));
        model.addAttribute("amountDeposits", amountDepositedService.findAllByDipoId(id));
        return "admin/depositedAmt/report";
        //return transactionService.findAllByDipoId(id);
    }
}


