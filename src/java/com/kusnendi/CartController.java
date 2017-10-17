/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kusnendi;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class CartController {

//    @Autowired
//    CartDAO cd;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShoppingWebAppPU");

    private EntityManager em = emf.createEntityManager();

    @RequestMapping()
    public String mainPage(Model model) {
//        List<Products> products = cd.findAll();
        List<Products> products;
        products = this.em.createNamedQuery("Products.findAll").getResultList();

        model.addAttribute("products", products);
        return "main";
    }

}
