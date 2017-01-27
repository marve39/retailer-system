package com.arindra.project.common.repositories;

import com.arindra.project.common.domain.EntityCategory;
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
public interface EntityCategoryRepository extends CrudRepository<EntityCategory, Long> {
     
    @Query("SELECT category FROM EntityCategory category WHERE LOWER(category.name) = LOWER(:name)")
    public EntityCategory findByOneCategory(@Param("name") String name);
    
    @Query("SELECT category FROM EntityCategory category WHERE LOWER(category.name) = LOWER(:name) AND category.id = :id")
    public EntityCategory findByOneNameAndId(@Param("name") String name, @Param("id") Integer id);
    
    @Query("SELECT category FROM EntityCategory category")
    public List<EntityCategory> findAllEntityCategory(Pageable pageable);

}

