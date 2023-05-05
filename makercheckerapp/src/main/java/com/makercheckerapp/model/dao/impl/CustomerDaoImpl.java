package com.makercheckerapp.model.dao.impl;

import com.makercheckerapp.model.dao.CustomerDao;
import com.makercheckerapp.model.dao.entities.CustomerMaster;
import com.makercheckerapp.model.dao.entities.CustomerTemp;
import com.makercheckerapp.model.exception.ResourceNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class CustomerDaoImpl implements CustomerDao {
    private SessionFactory sessionFactory;
    private String errorMessage = "Customer not found!";
    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){
       return sessionFactory.getCurrentSession();
    }

    @Override
    public List<CustomerMaster> getAllMasterCustomers() {
        return getSession().createQuery("select c from CustomerMaster c").getResultList();
    }

    @Override
    public List<CustomerTemp> getAllTempCustomers() {
        return getSession().createQuery("select c from CustomerTemp c").getResultList();
    }

    @Override
    public void updateCustomerMaster(CustomerMaster customer) {
        getSession().merge(customer);
    }

    @Override
    public void updateCustomerTemp(CustomerTemp customer) {
        getSession().merge(customer);
    }

    @Override
    public void addCustomerMaster(CustomerMaster customer) {
        getSession().persist(customer);
    }

    @Override
    public void addCustomerTemp(CustomerTemp customer) {
        getSession().persist(customer);
    }

    @Override
    public void deleteCustomerTemp(int customerId) {
        CustomerTemp customerTemp = getTempCustomerById(customerId);
        getSession().remove(customerTemp);
    }

    @Override
    public void deleteCustomerMaster(int customerId) {
        CustomerMaster customerMaster = getMasterCustomerById(customerId);
        getSession().remove(customerMaster);
    }

    @Override
    public void deleteCustomerMaster(String customerCode) {
        CustomerMaster customerMaster = getMasterCustomerByCode(customerCode);
        getSession().remove(customerMaster);
    }

    @Override
    public CustomerMaster getMasterCustomerById(int customerId) {
        CustomerMaster customerMaster = getSession().get(CustomerMaster.class,customerId);
        if(customerMaster == null)
            throw new ResourceNotFoundException(errorMessage);
        return customerMaster;
    }

    @Override
    public CustomerTemp getTempCustomerById(int customerId) {
        CustomerTemp customerTemp = getSession().get(CustomerTemp.class,customerId);
        if(customerTemp == null)
            throw new ResourceNotFoundException(errorMessage);
        return customerTemp;
    }

    @Override
    public CustomerMaster getMasterCustomerByCode(String customerCode) {
        List<CustomerMaster> customerMasters = getSession().createQuery(
                        "select c from CustomerMaster c where c.customerCode=:customerCode", CustomerMaster.class)
                .setParameter("customerCode",customerCode).getResultList();
        if (!customerMasters.isEmpty())
            return customerMasters.get(0);
        else
            throw new ResourceNotFoundException(errorMessage);
    }

    @Override
    public CustomerTemp getTempCustomerByCode(String customerCode) {
        List<CustomerTemp> customerTemps = getSession().createQuery(
                        "select c from CustomerTemp c where c.customerCode=:customerCode", CustomerTemp.class)
                .setParameter("customerCode",customerCode).getResultList();
        if (!customerTemps.isEmpty())
            return customerTemps.get(0);
        else
            throw new ResourceNotFoundException(errorMessage);
    }

    public CustomerTemp convertToCustomerTemp(CustomerMaster customerMaster){
        CustomerTemp customerTemp = new CustomerTemp();
        customerTemp.setCustomerCode(customerMaster.getCustomerCode());
        customerTemp.setCustomerName(customerMaster.getCustomerName());
        customerTemp.setCustomerAddress1(customerMaster.getCustomerAddress1());
        customerTemp.setCustomerAddress2(customerMaster.getCustomerAddress2());
        customerTemp.setCustomerPincode(customerMaster.getCustomerPincode());
        customerTemp.setCustomerEmail(customerMaster.getCustomerEmail());
        customerTemp.setContactNumber(customerMaster.getContactNumber());
        customerTemp.setPrimaryContactPerson(customerMaster.getPrimaryContactPerson());
        customerTemp.setRecordStatus(customerMaster.getRecordStatus());
        customerTemp.setActiveInactiveFlag(customerMaster.getActiveInactiveFlag());
        customerTemp.setCreateDate(customerMaster.getCreateDate());
        customerTemp.setCreatedBy(customerMaster.getCreatedBy());
        customerTemp.setModifiedDate(customerMaster.getModifiedDate());
        customerTemp.setModifiedBy(customerMaster.getModifiedBy());
        customerTemp.setAuthorizedDate(customerMaster.getAuthorizedDate());
        customerTemp.setAuthorizedBy(customerMaster.getAuthorizedBy());
        return customerTemp;
    }
    public CustomerMaster convertToCustomerMaster(CustomerTemp customerTemp){
        CustomerMaster customerMaster = new CustomerMaster();
        customerMaster.setCustomerId(customerTemp.getCustomerId());
        customerMaster.setCustomerCode(customerTemp.getCustomerCode());
        customerMaster.setCustomerName(customerTemp.getCustomerName());
        customerMaster.setCustomerAddress1(customerTemp.getCustomerAddress1());
        customerMaster.setCustomerAddress2(customerTemp.getCustomerAddress2());
        customerMaster.setCustomerPincode(customerTemp.getCustomerPincode());
        customerMaster.setCustomerEmail(customerTemp.getCustomerEmail());
        customerMaster.setContactNumber(customerTemp.getContactNumber());
        customerMaster.setPrimaryContactPerson(customerTemp.getPrimaryContactPerson());
        customerMaster.setRecordStatus(customerTemp.getRecordStatus());
        customerMaster.setActiveInactiveFlag(customerTemp.getActiveInactiveFlag());
        customerMaster.setCreateDate(customerTemp.getCreateDate());
        customerMaster.setCreatedBy(customerTemp.getCreatedBy());
        customerMaster.setModifiedDate(customerTemp.getModifiedDate());
        customerMaster.setModifiedBy(customerTemp.getModifiedBy());
        customerMaster.setAuthorizedDate(customerTemp.getAuthorizedDate());
        customerMaster.setAuthorizedBy(customerTemp.getAuthorizedBy());
        return customerMaster;
    }

    @Override
    public CustomerTemp searchByCustomerCode(String customerCode) {
        List<CustomerTemp> customerTemps = getSession().createQuery(
                        "select c from CustomerTemp c where c.customerCode=:customerCode", CustomerTemp.class)
                .setParameter("customerCode",customerCode).getResultList();
        if (!customerTemps.isEmpty())
            return customerTemps.get(0);
        else
            throw new ResourceNotFoundException(errorMessage);
    }
}
