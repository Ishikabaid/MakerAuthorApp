package com.makercheckerapp.model.dao.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "ishika_customer_temp_7")
public class CustomerTemp {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer customerId;
    @NotEmpty(message = "customer code can't be blank!")
    @Size(max = 10,message = "Max customer code length is 10")
    @Column(unique = true)
    private String customerCode;
    @NotEmpty(message = "name can't be blank!")
    @Size(max = 30,message = "Customer name max length is 30")
    private String customerName;
    @NotEmpty(message = "primary address can't be blank!")
    private String customerAddress1;
    private String customerAddress2;
    private Integer customerPincode;
    @Email(message = "invalid email syntax!")
    @NotEmpty(message = "email can't be blank!")
    private String customerEmail;
    private String contactNumber;
    @Column(length = 100)
    @NotEmpty(message = "contact person can't be blank!")
    private String primaryContactPerson;
    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus;
    private String activeInactiveFlag;
    private String createDate;
    private String createdBy;
    private String modifiedDate;
    private String modifiedBy;
    private String authorizedDate;
    private String authorizedBy;
    public CustomerTemp() {
    }

    public CustomerTemp(String customerCode, String customerName, String customerAddress1,
                          String customerAddress2, Integer customerPincode, String customerEmail,
                          String contactNumber, String primaryContactPerson, String activeInactiveFlag) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerAddress1 = customerAddress1;
        this.customerAddress2 = customerAddress2;
        this.customerPincode = customerPincode;
        this.customerEmail = customerEmail;
        this.contactNumber = contactNumber;
        this.primaryContactPerson = primaryContactPerson;
        this.activeInactiveFlag = activeInactiveFlag;
    }

    public CustomerTemp(Integer customerId, String customerCode, String customerName, String customerAddress1,
                        String customerAddress2, Integer customerPincode, String customerEmail, String contactNumber,
                        String primaryContactPerson, RecordStatus recordStatus, String activeInactiveFlag, String createDate, String createdBy,
                        String modifiedDate, String modifiedBy, String authorizedDate, String authorizedBy) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerAddress1 = customerAddress1;
        this.customerAddress2 = customerAddress2;
        this.customerPincode = customerPincode;
        this.customerEmail = customerEmail;
        this.contactNumber = contactNumber;
        this.primaryContactPerson = primaryContactPerson;
        this.recordStatus = recordStatus;
        this.activeInactiveFlag = activeInactiveFlag;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
        this.authorizedDate = authorizedDate;
        this.authorizedBy = authorizedBy;
    }

    public CustomerTemp(CustomerTemp customerTemp) {
        this.customerId = customerTemp.customerId;
        this.customerCode = customerTemp.customerCode;
        this.customerName = customerTemp.customerName;
        this.customerAddress1 = customerTemp.customerAddress1;
        this.customerAddress2 = customerTemp.customerAddress2;
        this.customerPincode = customerTemp.customerPincode;
        this.customerEmail = customerTemp.customerEmail;
        this.contactNumber = customerTemp.contactNumber;
        this.primaryContactPerson = customerTemp.primaryContactPerson;
        this.recordStatus = customerTemp.recordStatus;
        this.activeInactiveFlag = customerTemp.activeInactiveFlag;
        this.createDate = customerTemp.createDate;
        this.createdBy = customerTemp.createdBy;
        this.modifiedDate = customerTemp.modifiedDate;
        this.modifiedBy = customerTemp.modifiedBy;
        this.authorizedDate = customerTemp.authorizedDate;
        this.authorizedBy = customerTemp.authorizedBy;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress1() {
        return customerAddress1;
    }

    public void setCustomerAddress1(String customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }

    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }

    public Integer getCustomerPincode() {
        return customerPincode;
    }

    public void setCustomerPincode(Integer customerPincode) {
        this.customerPincode = customerPincode;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPrimaryContactPerson() {
        return primaryContactPerson;
    }

    public void setPrimaryContactPerson(String primaryContactPerson) {
        this.primaryContactPerson = primaryContactPerson;
    }

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getActiveInactiveFlag() {
        return activeInactiveFlag;
    }

    public void setActiveInactiveFlag(String activeInactiveFlag) {
        this.activeInactiveFlag = activeInactiveFlag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(String authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    @Override
    public String toString() {
        return "CustomerTemp{" +
                "customerId=" + customerId +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress1='" + customerAddress1 + '\'' +
                ", customerAddress2='" + customerAddress2 + '\'' +
                ", customerPincode=" + customerPincode +
                ", customerEmail='" + customerEmail + '\'' +
                ", contactNumber=" + contactNumber +
                ", primaryContactPerson='" + primaryContactPerson + '\'' +
                ", recordStatus=" + recordStatus +
                ", activeInactiveFlag='" + activeInactiveFlag + '\'' +
                ", createDate=" + createDate +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", authorizedDate=" + authorizedDate +
                ", authorizedBy='" + authorizedBy + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerTemp that = (CustomerTemp) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(customerCode, that.customerCode) && Objects.equals(customerName, that.customerName) && Objects.equals(customerAddress1, that.customerAddress1) && Objects.equals(customerAddress2, that.customerAddress2) && Objects.equals(customerPincode, that.customerPincode) && Objects.equals(customerEmail, that.customerEmail) && Objects.equals(contactNumber, that.contactNumber) && Objects.equals(primaryContactPerson, that.primaryContactPerson) && recordStatus == that.recordStatus && Objects.equals(activeInactiveFlag, that.activeInactiveFlag) && Objects.equals(createDate, that.createDate) && Objects.equals(createdBy, that.createdBy) && Objects.equals(modifiedDate, that.modifiedDate) && Objects.equals(modifiedBy, that.modifiedBy) && Objects.equals(authorizedDate, that.authorizedDate) && Objects.equals(authorizedBy, that.authorizedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerCode, customerName, customerAddress1, customerAddress2, customerPincode, customerEmail, contactNumber, primaryContactPerson, recordStatus, activeInactiveFlag, createDate, createdBy, modifiedDate, modifiedBy, authorizedDate, authorizedBy);
    }
}
