/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thq.controllers;

import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
public class IndexController {
    @Autowired
    private LocalSessionFactoryBean factory;
    
    
    @RequestMapping("/")
    @Transactional
    public String Index(Model model){
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Product");
        
        model.addAttribute("products", q.getResultList());
        return "index";
    }
}
