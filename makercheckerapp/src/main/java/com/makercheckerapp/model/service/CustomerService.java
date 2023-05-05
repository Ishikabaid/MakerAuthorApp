package com.makercheckerapp.model.service;

import com.makercheckerapp.model.dao.entities.CustomerMaster;
import com.makercheckerapp.model.dao.entities.CustomerTemp;

import java.util.List;

public interface CustomerService {
    List<CustomerMaster> getAllMasterCustomers();
    List<CustomerTemp> getAllTempCustomers();
    void updateCustomerMaster(CustomerMaster customer);
    void updateCustomerTemp(CustomerTemp customer);
    void addCustomerMaster(CustomerMaster customer);
    void addCustomerTemp(CustomerTemp customer);
    void deleteCustomerTemp(int customerId);
    void deleteCustomerMaster(int customerId);
    CustomerMaster getMasterCustomerById(int customerId);
    CustomerTemp getTempCustomerById(int customerId);
    CustomerTemp convertToCustomerTemp(CustomerMaster customerMaster);
    CustomerMaster convertToCustomerMaster(CustomerTemp customerTemp);
    CustomerTemp searchByCustomerCode(String customerCode);
    CustomerMaster getMasterCustomerByCode(String customerCode);
    CustomerTemp getTempCustomerByCode(String customerCode);
    void deleteCustomerMaster(String customerCode);
}
