package com.utsicom.webapp.service.impl; 

import com.utsicom.webapp.model.Item;
import com.utsicom.webapp.repository.ItemRepository;
import com.utsicom.webapp.service.ItemService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author utsi
 */

@Service
@Transactional
public class ItemServiceImpl extends GenericServiceImpl<Item> implements  ItemService{ 
@Autowired
    private ItemRepository itemDAO;
    private List<Item> items;//used for caching

    @Override
    public List<Item> getAll() {
        if (items == null) {
            items = itemDAO.findAll();
        }
        return items;
    }

    @Override
    public void saveOrUpdate(Item item) {
        itemDAO.save(item);
        items = null;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
        itemDAO.deleteById(id);
        return true;
        }
        return false;
    }

   
    @Override
    public Optional<Item> getById(int id) {
    return itemDAO.findById(id);
        

    }

    @Override
    public Item getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> getAllById(Iterable<Integer> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
