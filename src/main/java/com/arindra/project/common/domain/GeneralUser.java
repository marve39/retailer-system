/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.common.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "GRL_user")
public class GeneralUser {
    final @Id Integer id;
    final String name;
    final String address;
    final String phone;
    final String username;
    final String password;
    
    protected GeneralUser() {
        this(null, null, null, null, null, null);
    }
}
