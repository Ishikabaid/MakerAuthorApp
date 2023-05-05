package com.makercheckerapp.web.controller;

import com.makercheckerapp.model.dao.entities.CustomerMaster;
import com.makercheckerapp.model.dao.entities.CustomerTemp;
import com.makercheckerapp.model.dao.entities.UserEntity;
import com.makercheckerapp.model.service.CustomerService;
import com.makercheckerapp.model.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("model-config.xml");
//       CustomerService customerService = context.getBean("customerService", CustomerService.class);

       /* CustomerMaster customerMaster = new CustomerMaster("n19","geeta","noida","delhi",123,"ab@gmail",45675434,"nikita","Y");
        CustomerMaster customerMaster1 = new CustomerMaster("n20","sita","rj","mumbai",1234,"abc@gmail",4563434,"aakash","N");
        CustomerMaster customerMaster2 = new CustomerMaster("n21","ram","raipur","chennai",1235,"abcd@gmail",562345434,"sid","Y");
        CustomerMaster customerMaster3 = new CustomerMaster("n22","shyam","jaipur","hyd",1236,"abef@gmail",45674544,"sonia","N");
        customerService.addCustomerMaster(customerMaster);
        customerService.addCustomerMaster(customerMaster1);
        customerService.addCustomerMaster(customerMaster2);
        customerService.addCustomerMaster(customerMaster3);*/
//
//       CustomerTemp customerTemp = new CustomerTemp("abcd","sandeep","noida","delhi",123,"ab@gmail",45675434,"nikita","Y");
//        CustomerTemp customerTemp1 = new CustomerTemp("efgh","gaurav","rj","mumbai",1234,"abc@gmail",4563434,"aakash","N");
//        CustomerTemp customerTemp2 = new CustomerTemp("ijk","shweta","raipur","chennai",1235,"abcd@gmail",562345434,"sid","Y");
//        CustomerTemp customerTemp3 = new CustomerTemp("mnop","pranjal","jaipur","hyd",1236,"abef@gmail",45674544,"sonia","N");
//       customerService.addCustomerTemp(customerTemp);
//        customerService.addCustomerTemp(customerTemp1);
//        customerService.addCustomerTemp(customerTemp2);
//        customerService.addCustomerTemp(customerTemp3);
//
//
        UserService userService = context.getBean("userService", UserService.class);
        UserEntity user1=new UserEntity("ishika","ishika@gmail.com","$2a$12$ki7vA60iTb.45PodG/2/YeCEoVQ9qu5JvZ.TEIPp3oBMpZXIZceEK", List.of("MAKER"));
        UserEntity user2=new UserEntity("nikita","nikita@gmail.com","$2a$12$liReQleB9Vdttv.MYtdQMOh2N1WT4EIj6zp54wUXed6bH5MYCaOAK",List.of("CHECKER"));
        userService.addUser(user1);
        userService.addUser(user2);

    }
}