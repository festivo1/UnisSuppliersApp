/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.repository;

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
@Repository("transactionDAO")
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
    //@Query("select * from Transaction")
   //List<Transaction> findAllByDipo(1);
    //@Query("select * from Transaction join")
    @Query("select t from Transaction t where t.dipo.id=:id")
     List<Transaction> findAllByDipoId(@Param("id")int id);
}
