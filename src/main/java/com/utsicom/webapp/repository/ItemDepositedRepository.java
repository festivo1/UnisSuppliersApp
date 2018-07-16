/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.repository;

import com.utsicom.webapp.model.ItemDeposited;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author utsi
 */
@Repository("itemDepositedDAO")
public interface ItemDepositedRepository extends JpaRepository<ItemDeposited, Integer>{
    @Query("select i from ItemDeposited i where i.dipo.id=:id order by i.addedDate desc")
     List<ItemDeposited> findAllByDipoId(@Param("id")int id);
}
