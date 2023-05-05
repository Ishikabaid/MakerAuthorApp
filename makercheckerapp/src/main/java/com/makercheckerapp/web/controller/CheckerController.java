package com.makercheckerapp.web.controller;

import com.makercheckerapp.model.dao.entities.CustomerMaster;
import com.makercheckerapp.model.dao.entities.CustomerTemp;
import com.makercheckerapp.model.dao.entities.RecordStatus;
import com.makercheckerapp.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class CheckerController {
    private CustomerService customerService;
    LocalDate localDate = LocalDate.now();

    @Autowired
    public CheckerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("updatecustomermaster")
    public String updateCustomerGet(@RequestParam(name = "customerCode") String customerCode, ModelMap modelMap){
        CustomerMaster customerMaster = customerService.getMasterCustomerByCode(customerCode);
        modelMap.addAttribute("customer",customerMaster);
        return "updatecustomermaster";
    }

    @PostMapping("updatecustomermaster")
    public String updateCustomerPost(@Valid @ModelAttribute(name = "customer") CustomerMaster customer, BindingResult bindingResult, Principal principal){
        if (bindingResult.hasErrors()){
            return "updatecustomermaster";
        }
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = date.format(now);
        customer.setRecordStatus(RecordStatus.M);
        CustomerMaster newCustomer = new CustomerMaster(customer);
        CustomerTemp convertedCustomer = customerService.convertToCustomerTemp(newCustomer);
        convertedCustomer.setModifiedBy(principal.getName());
        convertedCustomer.setModifiedDate(currentDate);
        customerService.addCustomerTemp(convertedCustomer);
        return "redirect:showall";
    }

    @GetMapping("deletecustomermaster")
    public String deleteCustomerMaster(@RequestParam(name = "customerCode") String customerCode){
        CustomerMaster customerMaster = customerService.getMasterCustomerByCode(customerCode);
        customerMaster.setRecordStatus(RecordStatus.D);
        CustomerMaster newCustomer = new CustomerMaster(customerMaster);
        CustomerTemp convertedCustomer = customerService.convertToCustomerTemp(newCustomer);
        customerService.addCustomerTemp(convertedCustomer);
        return "redirect:showall";
    }

    @GetMapping("approve")
    public String approveCustomer(@RequestParam(name = "customerCode") String customerCode,Principal principal){
        CustomerTemp customerTemp = customerService.getTempCustomerByCode(customerCode);
        customerTemp.setAuthorizedBy(principal.getName());
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = date.format(now);
        customerTemp.setAuthorizedDate(currentDate);
        if(customerTemp.getRecordStatus().equals(RecordStatus.D) || customerTemp.getRecordStatus().equals(RecordStatus.DR)){
            CustomerMaster customerMaster = customerService.convertToCustomerMaster(customerTemp);
            customerService.deleteCustomerMaster(customerMaster.getCustomerCode());
            customerService.deleteCustomerTemp(customerTemp.getCustomerId());
        } else if(customerTemp.getRecordStatus().equals(RecordStatus.N) || customerTemp.getRecordStatus().equals(RecordStatus.NR))  {
            customerTemp.setRecordStatus(RecordStatus.A);
            CustomerMaster updatedCustomerMaster = customerService.convertToCustomerMaster(customerTemp);
            customerService.addCustomerMaster(updatedCustomerMaster);
            customerService.deleteCustomerTemp(customerTemp.getCustomerId());
        } else {
            CustomerMaster customerMaster = customerService.getMasterCustomerByCode(customerTemp.getCustomerCode());
            customerService.deleteCustomerMaster(customerMaster.getCustomerCode());
            customerTemp.setRecordStatus(RecordStatus.A);
            CustomerMaster updatedCustomerMaster = customerService.convertToCustomerMaster(customerTemp);
            customerService.addCustomerMaster(updatedCustomerMaster);
            customerService.deleteCustomerTemp(customerTemp.getCustomerId());
        }
        return "redirect:showall";
    }

    @GetMapping("reject")
    public String rejectCustomer(@RequestParam(name = "customerId") Integer customerId){
        CustomerTemp customerTemp = customerService.getTempCustomerById(customerId);
        if(customerTemp.getRecordStatus().equals(RecordStatus.N)){
            customerTemp.setRecordStatus(RecordStatus.NR);
        }else if (customerTemp.getRecordStatus().equals(RecordStatus.M)){
            customerTemp.setRecordStatus(RecordStatus.MR);
        }else if (customerTemp.getRecordStatus().equals(RecordStatus.D)){
            customerTemp.setRecordStatus(RecordStatus.DR);
        }
        customerService.updateCustomerTemp(customerTemp);
        return "redirect:showall";
    }

    @GetMapping("showcustomermaster")
    public String viewCustomerMaster(@RequestParam(name = "customerCode") String customerCode,ModelMap modelMap){
        CustomerMaster customerMaster = customerService.getMasterCustomerByCode(customerCode);
        modelMap.addAttribute("customer",customerMaster);
        return "viewcustomer";
    }
}
