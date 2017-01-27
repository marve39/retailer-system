/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.accounting.domain;

import com.arindra.project.common.domain.GeneralEntity;
import com.arindra.project.common.domain.GeneralUser;
import com.arindra.project.product.domain.ProductDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "ACC_purchase_order_detail")
public class PurchaseOrderDetail {
    final @Id Integer id;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    final ProductDetail productDetail;
    final Long unitPrice;
    final Integer quantity;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    protected PurchaseOrder purchaseOrder;
    
    protected PurchaseOrderDetail(){
        this(null, null, null, null);
    }
}
