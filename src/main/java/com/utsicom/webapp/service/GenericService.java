/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author utsi
 * @param <T>
 */
public interface GenericService<T> {

    List<T> getAll() ;
    //List<T> getAllByDipo(String dipoName) ;
    
    boolean delete(int id);

    void saveOrUpdate(T t) ;

    Optional<T> getById(int id) ;
    T getByName(String name);
    List<T> getAllById(Iterable<Integer> id);

}
