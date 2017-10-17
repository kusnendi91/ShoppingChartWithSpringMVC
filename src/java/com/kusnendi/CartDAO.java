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
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository

public class CartDAO {
    @PersistenceUnit
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShoppingWebAppPU");
    
    private EntityManager em;

    public CartDAO() {
    }
    
    
    
    public void register(Orders orders){
        emf = Persistence.createEntityManagerFactory("ShoppingWebAppPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(orders);
        em.getTransaction().commit();
        
    }
    
    public List<Products> findAll(){
        List<Products> products;
        products = this.em.createNamedQuery("Products.findAll").getResultList();
//        Query qwr = this.em.createQuery("SELECT p FROM PRODUCTS P");
//        products = qwr.getResultList();
        return products;
    }
    
    public Products findById(int productId){
        return this.em.find(Products.class, productId);
    }
    
}
