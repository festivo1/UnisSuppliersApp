package com.utsicom.webapp.service.impl; 

import com.utsicom.webapp.model.Employee;
import com.utsicom.webapp.model.Employee;
import com.utsicom.webapp.repository.EmployeeRepository;
import com.utsicom.webapp.service.EmployeeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl extends GenericServiceImpl<Employee> implements EmployeeService{ 

    @Autowired
    private EmployeeRepository employeeDAO;
    private List<Employee> employees;//used for caching

    @Override
    public List<Employee> getAll() {
        if (employees == null) {
            employees = employeeDAO.findAll();
        }
        return employees;
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        employeeDAO.save(employee);
        employees = null;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
        employeeDAO.deleteById(id);
        return true;
        }
        return false;
    }

   
    @Override
    public Optional<Employee> getById(int id) {
    return employeeDAO.findById(id);
        

    }

    @Override
    public Employee getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getAllById(Iterable<Integer> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
