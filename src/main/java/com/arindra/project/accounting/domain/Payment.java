/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.accounting.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "ACC_payment")
public class Payment {
    final @Id Long id;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "payment")
    final Invoice invoice;
    
    final Integer paymentType;
    final String bank;
    final String transactionCode;
    final Long amount;
    
    protected Payment(){
        this(null, null, null, null, null, null);
    }
}
