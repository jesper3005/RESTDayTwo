/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.webtrade.todelete.data;

import dk.webtrade.todelete.entity.Address;
import dk.webtrade.todelete.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mapper.CustomerMapper;

/**
 *
 * @author thomas
 */
public class DataFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public EntityManager getManager() {
        return emf.createEntityManager();
    }

    public Customer getCustomerById(int id) {
        return getManager().find(Customer.class, id);
    }
    public List<CustomerMapper> getAllAddresses(){
        EntityManager em = getManager();
        return em.createQuery("SELECT NEW mapper.CustomerMapper(a.id, a.street, a.zip, a.no) FROM Address a").getResultList();
        //return em.createQuery("SELECT a FROM Address a").getResultList();
    }
    
    public List<Customer> getAllCustomers(){
        EntityManager em = getManager();
        return em.createQuery("SELECT c FROM Customer c").getResultList();
    }

    public Customer createCustomer(Customer c) {
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }
    public void createAddress(Address a ){
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();
            
            em.merge(a);
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public void populate() {
        System.out.println("populate");
        DataFacade df = new DataFacade();
        Customer c1 = new Customer("Henriette", "Albertsen", 23);
        Customer c2 = new Customer("Hans", "Albertsen", 23);
        Customer c3 = new Customer("Hassan", "Albertsen", 23);
        Customer c4 = new Customer("Harun", "Albertsen", 23);
        Customer c5 = new Customer("Hugin", "Albertsen", 23);
        
        Address a1 = new Address("strandvej", 230, "3050");
        Address a2 = new Address("østerbrogade", 132, "2100");
        Address a3 = new Address("versterfælledvej", 15, "1732");
        
        c1.setAddress(a1);
        c2.setAddress(a1);
        c3.setAddress(a2);
        c4.setAddress(a2);
        c5.setAddress(a3);

        df.createAddress(a1);
        df.createAddress(a2);
        df.createAddress(a3);
    }
}
