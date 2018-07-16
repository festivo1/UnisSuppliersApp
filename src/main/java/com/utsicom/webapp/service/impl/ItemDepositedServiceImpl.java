package com.utsicom.webapp.service.impl; 

import com.utsicom.webapp.model.ItemDeposited;
import com.utsicom.webapp.model.ItemDeposited;
import com.utsicom.webapp.model.Leakage;
import com.utsicom.webapp.repository.ItemDepositedRepository;
import com.utsicom.webapp.service.ItemDepositedService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemDepositedServiceImpl extends GenericServiceImpl<ItemDeposited> implements ItemDepositedService{ 


    @Autowired
    private ItemDepositedRepository itemDepositedDAO;
    private List<ItemDeposited> itemDeposited;//used for caching

    @Override
    public List<ItemDeposited> getAll() {
        if (itemDeposited == null) {
            itemDeposited = itemDepositedDAO.findAll();
        }
        return itemDeposited;
    }

    @Override
    public void saveOrUpdate(ItemDeposited itemDeposited) {
        itemDepositedDAO.save(itemDeposited);
        itemDeposited = null;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
        itemDepositedDAO.deleteById(id);
        return true;
        }
        return false;
    }

   
    @Override
    public Optional<ItemDeposited> getById(int id) {
    return itemDepositedDAO.findById(id);
        

    }

    @Override
    public ItemDeposited getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemDeposited> getAllById(Iterable<Integer> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public List<ItemDeposited> findAllByDipoId(int id){
       itemDeposited=itemDepositedDAO.findAllByDipoId(id);
        return itemDeposited;
    }

}
