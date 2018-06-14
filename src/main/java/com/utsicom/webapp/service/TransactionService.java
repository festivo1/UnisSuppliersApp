/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.service;

import com.utsicom.webapp.model.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author utsi
 */

public interface TransactionService extends GenericService<Transaction>{
    //@Query("select * from TransactionService")
   //List<Transaction> findAllByDipo(1);
     //@Query("select t from Transaction t where t.dipoId=:id")
//    @Query("select t from Transaction t where t.dipo.id=11")
//     List<Transaction> findAllByDipoId(@Param("id")int id);
     List<Transaction> findAllByDipoId(int id);
}
