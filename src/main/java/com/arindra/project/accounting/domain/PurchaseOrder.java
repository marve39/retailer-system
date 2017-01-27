/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.accounting.domain;

import com.arindra.project.common.domain.GeneralEntity;
import com.arindra.project.common.domain.GeneralUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author Arindra
 */
@Entity
@Data
@RequiredArgsConstructor
@Table(name = "ACC_purchase_order")
public class PurchaseOrder {
    final @Id String id;
    final Timestamp orderDate;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    final GeneralUser user;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    final GeneralEntity entity;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchaseOrder")
    protected List<PurchaseOrderDetail> purchaseOrderDetail;
    final Long totalPrice;
    
    protected PurchaseOrder(){
        this(null, null, null, null, null);
    }
}
