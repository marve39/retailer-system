/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.common.controllers;

import com.arindra.project.common.domain.EntityCategory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arindra.project.common.domain.GeneralEntity;
import com.arindra.project.common.repositories.EntityCategoryRepository;
import com.arindra.project.common.repositories.GeneralEntityRepository;
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
@RequestMapping("/api/general")
public class GeneralEntityController {
    
    @Autowired
    GeneralEntityRepository entityRepo;
    
    @Autowired
    EntityCategoryRepository entityCategoryRepo;
    
    @RequestMapping(method=RequestMethod.POST, value="/entity/add/{username}/{password}")
    public boolean createEntity(@RequestBody GeneralEntity generalEntity, @PathVariable("username") String username, @PathVariable("password") String password){
        if (generalEntity.getEntityCategory() != null){
            EntityCategory entityCategory = entityCategoryRepo.findByOneNameAndId(generalEntity.getEntityCategory().getName(),generalEntity.getEntityCategory().getId());
            if (entityCategory != null){
                entityRepo.save(generalEntity);
                return true;
            }
        }
        return false;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/entity_category/add/{username}/{password}")
    public boolean createEntityCategory(@RequestBody EntityCategory entityCategory, @PathVariable("username") String username, @PathVariable("password") String password){
        if (entityCategory != null){
            if (entityCategory.getId() != null && entityCategory.getName() != null){
                entityCategoryRepo.save(entityCategory);
                return true;
            }
        }
        return false;
    }
/*
 @RequestMapping(method=RequestMethod.GET, value="/gr_entity_create_demo_category")
    public void createDemoEntity(){//@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("limit") Integer limit){
       EntityCategory entityCategory1 = new EntityCategory(1,"Supplier");
       EntityCategory entityCategory2 = new EntityCategory(2,"Distributor");
       EntityCategory entityCategory3 = new EntityCategory(3,"Retailer");
       entityCategoryRepo.save(entityCategory1);
       entityCategoryRepo.save(entityCategory2);
       entityCategoryRepo.save(entityCategory3);
    }
    
    
    @RequestMapping(method=RequestMethod.GET, value="/gr_entity_create/{id}/{category}")
    public GeneralEntity createDemoEntity(@PathVariable("id") String id, @PathVariable("category") String category){//@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("limit") Integer limit){
       EntityCategory entityCategory = entityCategoryRepo.findByOneCategory(category);
       GeneralEntity generalEntity = new GeneralEntity(id,"test","address","3215325", entityCategory);
       entityRepo.save(generalEntity);
       return generalEntity;
    }
  */   
    @RequestMapping(method=RequestMethod.GET, value="/entity/query/{start}/{numrows}/{username}/{password}")
    public List<GeneralEntity> findAllEntity(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("start") Integer start,@PathVariable("numrows") Integer numrows){
       List<GeneralEntity> listEntity =  entityRepo.findAllEntity(new PageRequest(start,numrows));
       return listEntity;
    }

    @RequestMapping(method=RequestMethod.GET, value="/entity_category/query/{start}/{numrows}/{username}/{password}")
    public List<EntityCategory> findAllEntityCategory(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("start") Integer start,@PathVariable("numrows") Integer numrows){
       List<EntityCategory> listEntityCategory =  entityCategoryRepo.findAllEntityCategory(new PageRequest(start,numrows));
       return listEntityCategory;
    }
    
}

