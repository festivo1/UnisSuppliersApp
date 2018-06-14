
package com.utsicom.webapp.service.impl;

import com.utsicom.webapp.model.AmountDeposited;
import com.utsicom.webapp.model.AmountDeposited;
import com.utsicom.webapp.repository.AmountDepositedRepository;
import com.utsicom.webapp.service.AmountDepositedService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AmountDepositedServiceImpl extends GenericServiceImpl<AmountDeposited>implements
        AmountDepositedService{ 

   
    @Autowired
    private AmountDepositedRepository amountDepositedDAO;
    private List<AmountDeposited> amountDepositeds;//used for caching

    @Override
    public List<AmountDeposited> getAll() {
        if (amountDepositeds == null) {
            amountDepositeds = amountDepositedDAO.findAll();
        }
        return amountDepositeds;
    }

    @Override
    public void saveOrUpdate(AmountDeposited amountDeposited) {
        amountDepositedDAO.save(amountDeposited);
        amountDepositeds = null;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
        amountDepositedDAO.deleteById(id);
        return true;
        }
        return false;
    }

   
    @Override
    public Optional<AmountDeposited> getById(int id) {
    return amountDepositedDAO.findById(id);
        

    }

    @Override
    public AmountDeposited getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AmountDeposited> getAllById(Iterable<Integer> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
