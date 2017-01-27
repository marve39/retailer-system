/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.common.repositories;

import com.arindra.project.common.domain.GeneralUser;
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
public interface GeneralUserRepository extends CrudRepository<GeneralUser, Long> {
    @Query("SELECT user FROM GeneralUser user")
    public List<GeneralUser> findAllUser(Pageable pageable);
}
