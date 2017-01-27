/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.accounting.controllers;

import com.arindra.project.accounting.domain.Invoice;
import com.arindra.project.accounting.domain.InvoiceDetail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arindra.project.accounting.repositories.InvoiceRepository;
import com.arindra.project.accounting.repositories.InvoiceDetailRepository;
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
@RequestMapping("/api/accounting/invoice")
public class InvoiceController {
    @Autowired
    InvoiceRepository invoiceRepo;

    @Autowired
    InvoiceDetailRepository invoiceDetailRepo;

    @RequestMapping(method = RequestMethod.POST, value = "/add/{username}/{password}")
    public boolean createInvoice(@RequestBody Invoice invoice, @PathVariable("username") String username, @PathVariable("password") String password) {
        if (invoice != null) {
            invoiceRepo.save(invoice);
            return true;
        }
        return false;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/detail/add/{username}/{password}")
    public boolean createInvoiceDetail(@RequestBody InvoiceDetail invoiceDetail, @PathVariable("username") String username, @PathVariable("password") String password) {
        if (invoiceDetail != null) {
            invoiceDetailRepo.save(invoiceDetail);
            return true;
        }
        return false;
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/create_demo")
    public void createDemoPurchaseOrder(){//@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("limit") Integer limit){
       Invoice invoice = new Invoice("1",null);
       InvoiceDetail invoiceDetail = new InvoiceDetail(new Long(1),null,new Long(1));
       
       invoiceRepo.save(invoice);
       invoiceDetailRepo.save(invoiceDetail);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/query/{start}/{numrows}/{username}/{password}")
    public List<Invoice> findAllPurchaseOrder(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("start") Integer start,@PathVariable("numrows") Integer numrows){
       List<Invoice> listInvoice =  invoiceRepo.findAllInvoice(new PageRequest(start,numrows));
       return listInvoice;
    }
    @RequestMapping(method=RequestMethod.GET, value="/detail/query/{start}/{numrows}/{username}/{password}")
    public List<InvoiceDetail> findAllPurchaseOrderDetail(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("start") Integer start,@PathVariable("numrows") Integer numrows){
       List<InvoiceDetail> listInvoiceDetail =  invoiceDetailRepo.findAllInvoiceDetail(new PageRequest(start,numrows));
       return listInvoiceDetail;
    }
}
