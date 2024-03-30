package com.company.dao;

import com.company.entity.Customer;
import lombok.NonNull;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CustomerDAOImpl implements CustomerDAO {
    private EntityManager entityManager =
            Persistence.createEntityManagerFactory("ris_lab3").createEntityManager();

    @Override
    public Customer add(@NonNull Customer customer) {
        entityManager.getTransaction().begin();
        Customer temp = entityManager.merge(customer);
        entityManager.getTransaction().commit();
        return temp;
    }

    @Override
    public Customer get(long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void remove(@NonNull Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.remove(get(customer.getId()));
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeById(@NonNull long id) {
        entityManager.getTransaction().begin();
        try{
            entityManager.remove(get(id));
        }catch(Exception e){}
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Customer> getAll() {
        TypedQuery<Customer> namedQuery = entityManager.createNamedQuery("Customer.getAll", Customer.class);
        return namedQuery.getResultList();
    }
}
