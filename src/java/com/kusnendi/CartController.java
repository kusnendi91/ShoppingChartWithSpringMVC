/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kusnendi;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class CartController {

//    @Autowired
//    CartDAO cd;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShoppingWebAppPU");

    private EntityManager em = emf.createEntityManager();
    
    List<Products> baseCart = new ArrayList<>();

    @RequestMapping()
    public String mainPage(HttpSession session,Model model) {
//        List<Products> products = cd.findAll();
        List<Products> products;
        products = this.em.createNamedQuery("Products.findAll").getResultList();
        //session.setAttribute(name, cart);
        session.setAttribute("products", products);
        session.setAttribute("baseCart", baseCart);
        return "main";
    }
    
    @RequestMapping(value="/add/{productId}")
    public String addToCart(@PathVariable("productId") Integer productId,HttpSession session){
        List<Products> item = (List<Products>) session.getAttribute("baseCart");
        Products cart = this.em.find(Products.class,productId);
        item.add(cart);
        return "add";
   
    }
    
    @RequestMapping(value="/cart")
    public String cart(){
        return "cart";
    }
    
//    @RequestMapping(value="/logout")
//    public String logout(HttpSession session){
//        session.invalidate();
//        return "logout";
//    }
    


}
