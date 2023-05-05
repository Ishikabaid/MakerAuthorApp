package com.makercheckerapp.model.dao;

import com.makercheckerapp.model.dao.entities.CustomerMaster;
import com.makercheckerapp.model.dao.entities.CustomerTemp;

import java.util.List;

public interface CustomerDao {
    List<CustomerMaster> getAllMasterCustomers();
    List<CustomerTemp> getAllTempCustomers();
    void updateCustomerMaster(CustomerMaster customer);
    void updateCustomerTemp(CustomerTemp customer);
    void addCustomerMaster(CustomerMaster customer);
    void addCustomerTemp(CustomerTemp customer);
    void deleteCustomerTemp(int customerId);
    void deleteCustomerMaster(int customerId);
    void deleteCustomerMaster(String customerCode);
    CustomerMaster getMasterCustomerById(int customerId);
    CustomerTemp getTempCustomerById(int customerId);
    CustomerMaster getMasterCustomerByCode(String customerCode);
    CustomerTemp getTempCustomerByCode(String customerCode);
    CustomerTemp convertToCustomerTemp(CustomerMaster customerMaster);
    CustomerMaster convertToCustomerMaster(CustomerTemp customerTemp);
    CustomerTemp searchByCustomerCode(String customerCode);

}
