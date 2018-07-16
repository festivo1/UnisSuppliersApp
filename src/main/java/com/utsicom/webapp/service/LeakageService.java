/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.service;

import com.utsicom.webapp.model.Leakage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author utsi
 */

public interface LeakageService extends GenericService<Leakage>{
    List<Leakage> findAllByDipoId(int id);
}
