package com.utsicom.webapp.service.impl; 

import com.utsicom.webapp.model.Supplier;
import com.utsicom.webapp.model.Supplier;
import com.utsicom.webapp.repository.SupplierRepository;
import com.utsicom.webapp.service.SupplierService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SupplierServiceImpl extends GenericServiceImpl<Supplier> implements SupplierService{ 
@Autowired
    private SupplierRepository supplierDAO;
    private List<Supplier> suppliers;//used for caching

    @Override
    public List<Supplier> getAll() {
        if (suppliers == null) {
            suppliers = supplierDAO.findAll();
        }
        return suppliers;
    }

    @Override
    public void saveOrUpdate(Supplier supplier) {
        supplierDAO.save(supplier);
        suppliers = null;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
        supplierDAO.deleteById(id);
        return true;
        }
        return false;
    }

   
    @Override
    public Optional<Supplier> getById(int id) {
    return supplierDAO.findById(id);
        

    }

    @Override
    public Supplier getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Supplier> getAllById(Iterable<Integer> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
