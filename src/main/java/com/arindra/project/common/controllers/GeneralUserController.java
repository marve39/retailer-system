/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arindra.project.common.controllers;

import com.arindra.project.common.repositories.GeneralUserRepository;
import com.arindra.project.common.domain.GeneralUser;
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
@RequestMapping("/api/general/user")
public class GeneralUserController {

    @Autowired
    GeneralUserRepository userRepo;

    @RequestMapping(method = RequestMethod.POST, value = "/add/{username}/{password}")
    public boolean createEntity(@RequestBody GeneralUser generalUser, @PathVariable("username") String username, @PathVariable("password") String password) {
        if (generalUser != null) {
            userRepo.save(generalUser);
            return true;
        }
        return false;
    }
    /*
    @RequestMapping(method=RequestMethod.GET, value="/create/{id}")
    public GeneralUser createDemoEntity(@PathVariable("id") Integer id){//@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("limit") Integer limit){
       GeneralUser generalUser = new GeneralUser(id,"test","address","3215325", "username","password");
       userRepo.save(generalUser);
       return generalUser;
    }
    */
    @RequestMapping(method=RequestMethod.GET, value="/query/{start}/{numrows}/{username}/{password}")
    public List<GeneralUser> findAllEntity(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("start") Integer start,@PathVariable("numrows") Integer numrows){
       List<GeneralUser> listUser =  userRepo.findAllUser(new PageRequest(start,numrows));
       return listUser;
    }
}
