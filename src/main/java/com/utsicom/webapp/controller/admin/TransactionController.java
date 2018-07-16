/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.controller.admin;

import com.utsicom.webapp.dto.TransactionDTO;
import com.utsicom.webapp.model.AmountDeposited;
import com.utsicom.webapp.model.Dipo;
import com.utsicom.webapp.model.Item;
import com.utsicom.webapp.model.ItemDeposited;
import com.utsicom.webapp.model.Supplier;
import com.utsicom.webapp.model.Transaction;
import com.utsicom.webapp.model.User;
import com.utsicom.webapp.repository.DipoRepository;
import com.utsicom.webapp.service.AmountDepositedService;
import com.utsicom.webapp.service.DipoService;
import com.utsicom.webapp.service.ItemDepositedService;
import com.utsicom.webapp.service.ItemService;
import com.utsicom.webapp.service.SupplierService;
import com.utsicom.webapp.service.TransactionService;
import com.utsicom.webapp.service.UserService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author utsi
 */
@Controller
@RequestMapping("admin/transactions")
public class TransactionController {

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
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ItemDepositedService itemDepositedService;

//    @InitBinder
//    public void bindingPreparation(WebDataBinder binder) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
//        binder.registerCustomEditor(Date.class, orderDateEditor);
//    }
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int page) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println(userService.findByEmail(auth.getName()));
        model.addAttribute("userName", "Welcome " + user.getFirstName());
        int id = user.getId();
        System.out.println(id);
        //model.addAttribute("user", userService.findByEmail(String email));
        model.addAttribute("dipos", dipoRepo.findAll(PageRequest.of(page, 9)));//(PageRequest(page, 5)));
//        if (dipoService.getById(id).isPresent()) {
//            model.addAttribute("dipo", dipoService.getById(id));
//        }
        // model.addAttribute("dipo", dipoService.getById(id));
        model.addAttribute("currentPage", page);
        model.addAttribute("suppliers", supplierService.getAll());
        model.addAttribute("items", itemService.getAll());
        System.out.println(itemService.getAll());
        // model.addAttribute("dipos",dipoService.getAll(PageRequest.of(page, 9));
        System.out.println(user.getFirstName());
        // return "admin_shared/fragments";
        model.addAttribute("amountdeposits", amountDepositedService.getAll());
        model.addAttribute("transactions", transactionService.getAll());
        return "admin/transactions/index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(TransactionDTO transactionDTO) throws ParseException {
        //System.out.println("save bhitra aayooooooooooooooooooooooooooo");
        Transaction transaction = new Transaction();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(transactionDTO.getAddedDate());
        //System.out.println(transactionDTO.getAddedDate());
        transaction.setAddedDate(date);
        transaction.setId(transactionDTO.getId());
        transaction.setSupplier(new Supplier(transactionDTO.getSid()));
        transaction.setDipo(new Dipo(transactionDTO.getDid()));
        transaction.setItem(new Item(transactionDTO.getIid()));
        int refilledNum = transactionDTO.getTransactedNumber();//only refilledNUmber
        transaction.setTransactedNumber(transactionDTO.getTransactedNumber());//refilledNumber
        int soldNumber = transactionDTO.getSoldNumber();
        transaction.setSoldNumber(transactionDTO.getSoldNumber());
        int refilledRate = transactionDTO.getRefilledRate();
        transaction.setRefilledRate(transactionDTO.getRefilledRate());
        int emptyRate = transactionDTO.getEmptyRate();
        transaction.setEmptyRate(transactionDTO.getEmptyRate());
        transactionService.saveOrUpdate(transaction);
        Integer value = refilledNum * refilledRate + soldNumber * emptyRate;
        
        AmountDeposited amt = new AmountDeposited();
        amt.setDipo(new Dipo(transactionDTO.getDid()));
        amt.setDepositedAmount(0);
        amt.setDecrementedAmount(value);
        amt.setAddedDate(date);
        amountDepositedService.saveOrUpdate(amt);

        ItemDeposited itemDeposited = new ItemDeposited();
        itemDeposited.setDipo(new Dipo(transactionDTO.getDid()));
        itemDeposited.setItem(new Item(transactionDTO.getIid()));
        itemDeposited.setSupplier(new Supplier(transactionDTO.getSid()));
        itemDeposited.setDepositedNumber(0);
        itemDeposited.setRefilledNumber(refilledNum);
        itemDeposited.setAddedDate(date);
        itemDepositedService.saveOrUpdate(itemDeposited);

        return "redirect:/admin";

    }

    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Dipo> create(@PathVariable("id") int id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println(userService.findByEmail(auth.getName()));
        model.addAttribute("userName", "Welcome " + user.getFirstName());

        model.addAttribute("transactions", transactionService.getAll());
        model.addAttribute("suppliers", supplierService.getAll());

        System.out.println(dipoService.getById(id));
        model.addAttribute("dipo", dipoService.getById(id));
        model.addAttribute("items", itemService.getAll());
        //return "admin/transactions/create";
        return dipoService.getById(id);
    }

    @RequestMapping(value = "/report/{id}", method = RequestMethod.GET)
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
        return "admin/report/dipoReport";
        //return transactionService.findAllByDipoId(id);
    }
}
