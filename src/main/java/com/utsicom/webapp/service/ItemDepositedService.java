/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.service;

import com.utsicom.webapp.model.ItemDeposited;
import com.utsicom.webapp.model.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author utsi
 */

public interface ItemDepositedService extends GenericService<ItemDeposited>{
     List<ItemDeposited> findAllByDipoId(int id);
}
