    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.repository;

import com.utsicom.webapp.model.AmountDeposited;
import com.utsicom.webapp.model.Leakage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author utsi
 */
@Repository("amountDepositedDAO")
public interface AmountDepositedRepository extends JpaRepository<AmountDeposited, Integer>{
   @Query("select a from AmountDeposited a where a.dipo.id=:id order by a.addedDate desc")
     List<AmountDeposited> findAllByDipoId(@Param("id")int id);
}
