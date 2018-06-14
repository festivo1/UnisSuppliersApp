/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.controller;

import com.utsicom.webapp.dto.TransactionDTO;
import com.utsicom.webapp.model.Dipo;
import com.utsicom.webapp.model.Item;
import com.utsicom.webapp.model.Supplier;
import com.utsicom.webapp.model.Transaction;
import com.utsicom.webapp.repository.DipoRepository;
import com.utsicom.webapp.service.DipoService;
import com.utsicom.webapp.service.ItemService;
import com.utsicom.webapp.service.SupplierService;
import com.utsicom.webapp.service.TransactionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author utsi
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @Autowired
    ItemService itemService;
    @Autowired
    SupplierService supplierService;
    @Autowired
    DipoService dipoService;
    @Autowired
    DipoRepository dipoRepo;
//    @Autowired
//    ReportDAO reportDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, @PathVariable("id") int id) {
        model.addAttribute("items", itemService.getAll());
        model.addAttribute("suppliers", supplierService.getAll());
        model.addAttribute("dipos", dipoService.getAll());
        //model.addAttribute("transactions", transactionService.getAllById(id));
        System.out.println(transactionService.getAll());
        return "admin/transactions/index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(TransactionDTO transactionDTO) {
        System.out.println("save bhitra aayooooooooooooooooooooooooooo");
        Transaction transaction = new Transaction();
        transaction.setId(transactionDTO.getId());
        transaction.setSupplier(new Supplier(transactionDTO.getSid()));
        transaction.setDipo(new Dipo(transactionDTO.getDid()));
        transaction.setItem(new Item(transactionDTO.getIid()));
        transaction.setTransactedNumber(transactionDTO.getTransactedNumber());
        transaction.setSoldNumber(transactionDTO.getSoldNumber());
        transaction.setRefilledRate(transactionDTO.getRefilledRate());
        transaction.setEmptyRate(transactionDTO.getEmptyRate());
//        transaction.setTransactedAmount(transactionDTO.getItemReceived());
//        transaction.setTransactedNumber(transactionDTO.getItemRefilled());
        //
        //System.out.println((transactionDTO.getTransactedAmount()));
//        ModelMapper mapper= new ModelMapper();
//        transaction = mapper.map(transactionDTO, Transaction.class);

        transactionService.saveOrUpdate(transaction);

        return "redirect:/dipos";

    }

    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Dipo> create(@PathVariable("id") int id, Model model) {

        model.addAttribute("transactions", transactionService.getAll());
        model.addAttribute("suppliers", supplierService.getAll());
        System.out.println(dipoService.getById(id));
        System.out.println(dipoService.getById(id));
        System.out.println(dipoService.getById(id));
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
        model.addAttribute("transactions", transactionService.findAllByDipoId(id));
        //model.addAttribute("transactions", transactionService.getAll());
        System.out.println(transactionService.findAllByDipoId(id));
        return "admin/report/dipoReport";
        //return transactionService.findAllByDipoId(id);
    }
}
