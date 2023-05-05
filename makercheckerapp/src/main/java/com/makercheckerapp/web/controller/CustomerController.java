package com.makercheckerapp.web.controller;

import com.makercheckerapp.model.dao.entities.CustomerMaster;
import com.makercheckerapp.model.dao.entities.CustomerTemp;
import com.makercheckerapp.model.dao.entities.RecordStatus;
import com.makercheckerapp.model.dao.entities.UserEntity;
import com.makercheckerapp.model.service.CustomerService;
import com.makercheckerapp.model.service.UserService;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService;
    private UserService userService;
    @Autowired
    public CustomerController(CustomerService customerService,UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String login(){
        return "login";
    }
    @GetMapping("/login")
    public String logout(){
        return "login";
    }

    @GetMapping("showall")
    public String showAllCustomers(ModelMap modelMap, Principal principal){
        String username = principal.getName();
        System.out.println("Principal"+username+"////////////////////////////////////");
        UserEntity currentUser = userService.getUserByUsername(username);
        System.out.println("current user"+currentUser+"//////////////////////");
        List<String> userProfile = currentUser.getProfile();

        for(String s:userProfile){
            System.out.println("//////////////////////////////////////////////////////");
            System.out.println(s);
        }
        if(userProfile.get(0).equalsIgnoreCase("MAKER")) {
            List<CustomerMaster> customerMasters = customerService.getAllMasterCustomers();
            List<CustomerTemp> customerTemps = customerService.getAllTempCustomers();
            List<CustomerMaster> validCustomerMasters = new ArrayList<>();
            modelMap.addAttribute("customers", customerTemps);

            for (CustomerMaster customerMaster: customerMasters){
                boolean flag = false;
                for (CustomerTemp customerTemp: customerTemps){
                    if(customerMaster.getCustomerCode().equals(customerTemp.getCustomerCode())){
                        flag = true;
                        break;
                    }
                }
                if(flag == false)
                    validCustomerMasters.add(customerMaster);
            }
            if (validCustomerMasters != null) {
                modelMap.addAttribute("customersmaster", validCustomerMasters);
            }
            return "showcustomers";
        } else if (userProfile.get(0).equals("CHECKER")) {
            modelMap.addAttribute("customers", customerService.getAllTempCustomers());
            return "checkerdashboard";
        }else {
            return "errorpage";
        }
    }

    @GetMapping("addCustomer")
    public String addCustomerGet(@ModelAttribute(name = "customer") CustomerTemp customer){
        return "addcustomer";
    }

    @PostMapping("addCustomer")
    public String addCustomerPost(@Valid @ModelAttribute(name = "customer") CustomerTemp customer, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            return "addcustomer";
        }
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = date.format(now);
        customer.setCreatedBy(principal.getName());
        customer.setCreateDate(currentDate);
        customer.setRecordStatus(RecordStatus.N);
        customerService.addCustomerTemp(customer);
        return "redirect:showall";
    }

    @GetMapping("updatecustomer")
    public String updateCustomerGet(@RequestParam(name = "customerId") Integer customerId,ModelMap modelMap){
        CustomerTemp customerTemp = customerService.getTempCustomerById(customerId);
        modelMap.addAttribute("customer",customerTemp);
        return "updatecustomer";
    }

    @PostMapping("updatecustomer")
    public String updateCustomerPost(@Valid @ModelAttribute(name = "customer") CustomerTemp customer, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            return "updatecustomer";
        }
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = date.format(now);
        customer.setModifiedBy(principal.getName());
        customer.setModifiedDate(currentDate);
        if(customer.getRecordStatus().equals(RecordStatus.N)) {
            customerService.updateCustomerTemp(customer);
        }else if(customer.getRecordStatus().equals(RecordStatus.NR)) {
            customer.setRecordStatus(RecordStatus.N);
            customerService.updateCustomerTemp(customer);
        }else {
            customer.setRecordStatus(RecordStatus.M);
            customerService.updateCustomerTemp(customer);
        }
        return "redirect:showall";
    }

    @GetMapping("delete")
    public String deleteTemp(@RequestParam(name = "customerId") Integer customerId){
        CustomerTemp customerTemp = customerService.getTempCustomerById(customerId);
        if(customerTemp.getRecordStatus().equals(RecordStatus.N)  || customerTemp.getRecordStatus().equals(RecordStatus.NR) || customerTemp.getRecordStatus().equals(RecordStatus.MR)) {
            customerService.deleteCustomerTemp(customerTemp.getCustomerId());
        }
        else {
            customerTemp.setRecordStatus(RecordStatus.D);
            customerService.updateCustomerTemp(customerTemp);
        }
        return "redirect:showall";
    }

    @GetMapping("showcustomer")
    public String viewCustomer(@RequestParam(name = "customerCode") String customerCode,ModelMap modelMap){
        CustomerTemp customerTemp = customerService.getTempCustomerByCode(customerCode);
        modelMap.addAttribute("customer",customerTemp);
        return "viewcustomer";
    }
}
