package com.makercheckerapp.model.service;

import com.makercheckerapp.model.dao.CustomerDao;
import com.makercheckerapp.model.dao.entities.CustomerMaster;
import com.makercheckerapp.model.dao.entities.CustomerTemp;
import com.makercheckerapp.model.service.aspect.CustomAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "customerService")
@Primary
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    @CustomAnnotation
    @Override
    public List<CustomerMaster> getAllMasterCustomers() {
        return customerDao.getAllMasterCustomers();
    }

    @CustomAnnotation
    @Override
    public List<CustomerTemp> getAllTempCustomers() {
        return customerDao.getAllTempCustomers();
    }
    @CustomAnnotation
    @Override
    public void updateCustomerMaster(CustomerMaster customer) {
        customerDao.updateCustomerMaster(customer);
    }
    @CustomAnnotation
    @Override
    public void updateCustomerTemp(CustomerTemp customer) {
        customerDao.updateCustomerTemp(customer);
    }
    @CustomAnnotation
    @Override
    public void addCustomerMaster(CustomerMaster customer) {
        customerDao.addCustomerMaster(customer);
    }
    @CustomAnnotation
    @Override
    public void addCustomerTemp(CustomerTemp customer) {
        customerDao.addCustomerTemp(customer);
    }
    @CustomAnnotation
    @Override
    public void deleteCustomerTemp(int customerId) {
        customerDao.deleteCustomerTemp(customerId);
    }
    @CustomAnnotation
    @Override
    public void deleteCustomerMaster(int customerId) {
        customerDao.deleteCustomerMaster(customerId);
    }
    @CustomAnnotation
    @Override
    public CustomerMaster getMasterCustomerById(int customerId) {
        return customerDao.getMasterCustomerById(customerId);
    }
    @CustomAnnotation
    @Override
    public CustomerTemp getTempCustomerById(int customerId) {
        return customerDao.getTempCustomerById(customerId);
    }
    @CustomAnnotation
    @Override
    public CustomerTemp convertToCustomerTemp(CustomerMaster customerMaster) {
        return customerDao.convertToCustomerTemp(customerMaster);
    }
    @CustomAnnotation
    @Override
    public CustomerMaster convertToCustomerMaster(CustomerTemp customerTemp) {
        return customerDao.convertToCustomerMaster(customerTemp);
    }
    @CustomAnnotation
    @Override
    public CustomerTemp searchByCustomerCode(String customerCode) {
        return customerDao.searchByCustomerCode(customerCode);
    }
    @CustomAnnotation
    @Override
    public CustomerMaster getMasterCustomerByCode(String customerCode) {
        return customerDao.getMasterCustomerByCode(customerCode);
    }
    @CustomAnnotation
    @Override
    public CustomerTemp getTempCustomerByCode(String customerCode) {
        return customerDao.getTempCustomerByCode(customerCode);
    }
    @CustomAnnotation
    @Override
    public void deleteCustomerMaster(String customerCode) {
        customerDao.deleteCustomerMaster(customerCode);
    }
}
