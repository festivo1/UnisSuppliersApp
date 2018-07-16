package com.utsicom.webapp.service.impl; 

import com.utsicom.webapp.model.Leakage;
import com.utsicom.webapp.model.Leakage;
import com.utsicom.webapp.repository.LeakageRepository;
import com.utsicom.webapp.service.LeakageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LeakageServiceImpl extends GenericServiceImpl<Leakage> implements LeakageService{ 

    @Autowired
    private LeakageRepository leakageDAO;
    private List<Leakage> leakages;//used for caching

    @Override
    public List<Leakage> getAll() {
        if (leakages == null) {
            leakages = leakageDAO.findAll();
        }
        return leakages;
    }

    @Override
    public void saveOrUpdate(Leakage leakage) {
        leakageDAO.save(leakage);
        leakages = null;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
        leakageDAO.deleteById(id);
        return true;
        }
        return false;
    }

   
    @Override
    public Optional<Leakage> getById(int id) {
    return leakageDAO.findById(id);
        

    }

    @Override
    public Leakage getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public List<Leakage> getAllById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Leakage> findAllByDipoId(int id){
       leakages=leakageDAO.findAllByDipoId(id);
        return leakages;
    }

}
