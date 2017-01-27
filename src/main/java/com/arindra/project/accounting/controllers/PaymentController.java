/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.accounting.controllers;

import com.arindra.project.accounting.domain.Payment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arindra.project.accounting.repositories.PaymentRepository;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Arindra
 */
@RestController
@RequestMapping("/api/accounting/payment")
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepo;

    @RequestMapping(method = RequestMethod.POST, value = "/add/{username}/{password}")
    public boolean createPayment(@RequestBody Payment payment, @PathVariable("username") String username, @PathVariable("password") String password) {
        if (payment != null) {
            paymentRepo.save(payment);
            return true;
        }
        return false;
    }
   
    @RequestMapping(method=RequestMethod.GET, value="/create_demo")
    public void createDemoPayment(){//@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("limit") Integer limit){
       Payment payment = new Payment(new Long(1),null,null,null,null,null);
       paymentRepo.save(payment);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/query/{start}/{numrows}/{username}/{password}")
    public List<Payment> findAllPayment(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("start") Integer start,@PathVariable("numrows") Integer numrows){
       List<Payment> listPayment =  paymentRepo.findAllPayment(new PageRequest(start,numrows));
       return listPayment;
    }
}
