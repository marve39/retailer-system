/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.common.repositories;

import com.arindra.project.common.domain.GeneralEntity;
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
public interface GeneralEntityRepository extends CrudRepository<GeneralEntity, String> {
     
 //   @Query("SELECT entity FROM GeneralEntity entity WHERE LOWER(tt.status) = LOWER(:status) and LOWER(tt.title) = LOWER(:title)")
 //   public List<GeneralEntity> findEntity(@Param("status") String status, @Param("title") String title);
    
    @Query("SELECT entity FROM GeneralEntity entity")
    public List<GeneralEntity> findAllEntity(Pageable pageable);

}
