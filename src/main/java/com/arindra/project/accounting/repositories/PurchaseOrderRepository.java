/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.accounting.repositories;

import com.arindra.project.accounting.domain.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Arindra
 */
@Transactional
public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, String> {
     
 //   @Query("SELECT entity FROM GeneralEntity entity WHERE LOWER(tt.status) = LOWER(:status) and LOWER(tt.title) = LOWER(:title)")
 //   public List<GeneralEntity> findEntity(@Param("status") String status, @Param("title") String title);
    
    @Query("SELECT purchaseOrder FROM PurchaseOrder purchaseOrder")
    public List<PurchaseOrder> findAllPurchaseOrder(Pageable pageable);

}
