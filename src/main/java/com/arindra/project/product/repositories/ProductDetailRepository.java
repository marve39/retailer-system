/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.product.repositories;

import com.arindra.project.product.domain.ProductDetail;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Arindra
 */
@Transactional
public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long> {
    @Query("SELECT productDetail FROM ProductDetail productDetail")
    public List<ProductDetail> findAllProductDetail(Pageable pageable);
}
