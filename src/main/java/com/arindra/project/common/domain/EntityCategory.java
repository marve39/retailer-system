/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author Arindra
 */
@Entity
@Data
@RequiredArgsConstructor
@Table(name = "GRL_entity_category")
public class EntityCategory {
    final @Id Integer id;
    final String name;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entityCategory")
    List<GeneralEntity> entity;
    protected EntityCategory() {
        this(null, null);
    }
}
