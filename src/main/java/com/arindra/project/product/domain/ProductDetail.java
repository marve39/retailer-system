/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.product.domain;

import com.arindra.project.accounting.domain.PurchaseOrderDetail;
import com.arindra.project.common.domain.GeneralEntity;
import com.arindra.project.common.domain.GeneralUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "PRD_product_detail")
public class ProductDetail {
    final @Id String id;
    final String name;
    final String description;
    final String picture;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetail")
    protected List<Product> products;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetail")
    protected List<PurchaseOrderDetail> purchaseOrderDetail;
    
    protected ProductDetail(){
        this(null, null, null, null);
    }
}
