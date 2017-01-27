/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.product.controllers;

import com.arindra.project.product.repositories.ProductRepository;
import com.arindra.project.product.repositories.ProductDetailRepository;
import com.arindra.project.common.repositories.GeneralEntityRepository;
import com.arindra.project.product.domain.Product;
import com.arindra.project.product.domain.ProductDetail;
import com.arindra.project.common.domain.GeneralEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Arindra
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductRepository productRepo;
    
    @Autowired
    ProductDetailRepository productDetailRepo;
        
    @Autowired
    GeneralEntityRepository generalEntityRepo;

    @RequestMapping(method = RequestMethod.POST, value = "/add/{username}/{password}")
    public boolean createProduct(@RequestBody Product product, @PathVariable("username") String username, @PathVariable("password") String password) {
        if (product != null) {
            productRepo.save(product);
            return true;
        }
        return false;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/detail/add/{username}/{password}")
    public boolean createProductDetail(@RequestBody ProductDetail productDetail, @PathVariable("username") String username, @PathVariable("password") String password) {
        if (productDetail != null) {
            productDetailRepo.save(productDetail);
            return true;
        }
        return false;
    }
    /*
    @RequestMapping(method=RequestMethod.GET, value="/create/{serialNumber}")
    public Product createDemoProduct(@PathVariable("serialNumber") String serialNumber){//@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("limit") Integer limit){
       ProductDetail productDetail = new ProductDetail("1","product1","desc","picture");
       productDetailRepo.save(productDetail);
       
       GeneralEntity generalEntity = generalEntityRepo.findOne("SUP-1");
       
       Product product = new Product(serialNumber,productDetail,generalEntity,null);
       productRepo.save(product);
       return product;
    }
*/
    
    @RequestMapping(method=RequestMethod.GET, value="/query/{start}/{numrows}/{username}/{password}")
    public List<Product> findAllProduct(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("start") Integer start,@PathVariable("numrows") Integer numrows){
       List<Product> listProduct =  productRepo.findAllProduct(new PageRequest(start,numrows));
       return listProduct;
    }
    
    
    @RequestMapping(method=RequestMethod.GET, value="/detail/query/{start}/{numrows}/{username}/{password}")
    public List<ProductDetail> findAllProductDetail(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("start") Integer start,@PathVariable("numrows") Integer numrows){
       List<ProductDetail> listProductDetail =  productDetailRepo.findAllProductDetail(new PageRequest(start,numrows));
       return listProductDetail;
    }
}
