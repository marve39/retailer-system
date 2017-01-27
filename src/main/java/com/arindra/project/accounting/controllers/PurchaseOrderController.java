/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.accounting.controllers;

import com.arindra.project.accounting.domain.PurchaseOrder;
import com.arindra.project.accounting.domain.PurchaseOrderDetail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arindra.project.accounting.repositories.PurchaseOrderRepository;
import com.arindra.project.accounting.repositories.PurchaseOrderDetailRepository;
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
@RequestMapping("/api/accounting/purchase_order")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepo;

    @Autowired
    PurchaseOrderDetailRepository purchaseOrderDetailRepo;

    @RequestMapping(method = RequestMethod.POST, value = "/add/{username}/{password}")
    public boolean createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder, @PathVariable("username") String username, @PathVariable("password") String password) {
        if (purchaseOrder != null) {
            purchaseOrderRepo.save(purchaseOrder);
            return true;
        }
        return false;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/detail/add/{username}/{password}")
    public boolean createPurchaseOrderDetail(@RequestBody PurchaseOrderDetail purchaseOrderDetail, @PathVariable("username") String username, @PathVariable("password") String password) {
        if (purchaseOrderDetail != null) {
            purchaseOrderDetailRepo.save(purchaseOrderDetail);
            return true;
        }
        return false;
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/create_demo")
    public void createDemoPurchaseOrder(){//@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("limit") Integer limit){
       PurchaseOrder purchaseOrder = new PurchaseOrder("1",new Timestamp(new Date().getTime()),null,null,new Long(0));
       PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail(1,null,new Long(10),1);
       
       purchaseOrderRepo.save(purchaseOrder);
       purchaseOrderDetailRepo.save(purchaseOrderDetail);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/query/{start}/{numrows}/{username}/{password}")
    public List<PurchaseOrder> findAllPurchaseOrder(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("start") Integer start,@PathVariable("numrows") Integer numrows){
       List<PurchaseOrder> listPurchaseOrder =  purchaseOrderRepo.findAllPurchaseOrder(new PageRequest(start,numrows));
       return listPurchaseOrder;
    }
    @RequestMapping(method=RequestMethod.GET, value="/detail/query/{start}/{numrows}/{username}/{password}")
    public List<PurchaseOrderDetail> findAllPurchaseOrderDetail(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("start") Integer start,@PathVariable("numrows") Integer numrows){
       List<PurchaseOrderDetail> listPurchaseOrderDetail =  purchaseOrderDetailRepo.findAllPurchaseOrderDetail(new PageRequest(start,numrows));
       return listPurchaseOrderDetail;
    }
}
