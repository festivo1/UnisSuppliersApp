package com.utsicom.webapp.service.impl; 

import com.utsicom.webapp.model.Transaction;
import com.utsicom.webapp.model.Transaction;
import com.utsicom.webapp.repository.TransactionRepository;
import com.utsicom.webapp.service.TransactionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionServiceImpl extends GenericServiceImpl<Transaction> implements TransactionService{
    @Autowired
    private TransactionRepository transactionDAO;
    private List<Transaction> transactions;//used for caching

    @Override
    public List<Transaction> getAll() {
        if (transactions == null) {
            transactions = transactionDAO.findAll();
        }
        return transactions;
    }

    @Override
    public void saveOrUpdate(Transaction transaction) {
        transactionDAO.save(transaction);
        transactions = null;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
        transactionDAO.deleteById(id);
        return true;
        }
        return false;
    }

   
    @Override
    public Optional<Transaction> getById(int id) {
    return transactionDAO.findById(id);
        

    }

    @Override
    public Transaction getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaction> getAllById(Iterable<Integer> id) {
        transactions=transactionDAO.findAllById(id);
        return transactions; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Transaction> findAllByDipoId(int id){
       transactions=transactionDAO.findAllByDipoId(id);
        return transactions;
    }

   

}
