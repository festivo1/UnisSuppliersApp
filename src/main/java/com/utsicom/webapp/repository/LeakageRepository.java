/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.repository;

import com.utsicom.webapp.model.Leakage;
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
@Repository("leakageDAO")
public interface LeakageRepository extends JpaRepository<Leakage, Integer> {
    @Query("select l from Leakage l where l.dipo.id=:id order by l.addedDate desc")
     List<Leakage> findAllByDipoId(@Param("id")int id);
}
