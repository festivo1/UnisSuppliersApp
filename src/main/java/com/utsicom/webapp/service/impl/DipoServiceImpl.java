package com.utsicom.webapp.service.impl;

import com.utsicom.webapp.model.Dipo;
import com.utsicom.webapp.service.DipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utsicom.webapp.repository.DipoRepository;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DipoServiceImpl extends GenericServiceImpl<Dipo> implements DipoService {

    @Autowired
    private DipoRepository dipoDAO;
    private List<Dipo> dipos;//used for caching

    @Override
    public List<Dipo> getAll() {
        if (dipos == null) {
            dipos = dipoDAO.findAll();
        }
        return dipos;
    }

    @Override
    public void saveOrUpdate(Dipo dipo) {
        dipoDAO.save(dipo);
        dipos = null;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
        dipoDAO.deleteById(id);
        return true;
        }
        return false;
    }

   
    @Override
    public Optional<Dipo> getById(int id) {
    return dipoDAO.findById(id);
        

    }

    @Override
    public Dipo getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dipo> getAllById(Iterable<Integer> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
