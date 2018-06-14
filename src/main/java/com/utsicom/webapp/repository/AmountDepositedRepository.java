/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.repository;

import com.utsicom.webapp.model.AmountDeposited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author utsi
 */
@Repository("amountDepositedDAO")
public interface AmountDepositedRepository extends JpaRepository<AmountDeposited, Integer>{
   
}
