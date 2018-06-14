package com.utsicom.webapp.service.impl; 

import com.utsicom.webapp.model.EmployeePayment;
import com.utsicom.webapp.model.EmployeePayment;
import com.utsicom.webapp.repository.EmployeePaymentRepository;
import com.utsicom.webapp.service.EmployeePaymentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeePaymentServiceImpl extends GenericServiceImpl<EmployeePayment>implements EmployeePaymentService{


    @Autowired
    private EmployeePaymentRepository employeePaymentDAO;
    private List<EmployeePayment> employeePayments;//used for caching

    @Override
    public List<EmployeePayment> getAll() {
        if (employeePayments == null) {
            employeePayments = employeePaymentDAO.findAll();
        }
        return employeePayments;
    }

    @Override
    public void saveOrUpdate(EmployeePayment employeePayment) {
        employeePaymentDAO.save(employeePayment);
        employeePayments = null;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
        employeePaymentDAO.deleteById(id);
        return true;
        }
        return false;
    }

   
    @Override
    public Optional<EmployeePayment> getById(int id) {
    return employeePaymentDAO.findById(id);
        

    }

    @Override
    public EmployeePayment getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EmployeePayment> getAllById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
