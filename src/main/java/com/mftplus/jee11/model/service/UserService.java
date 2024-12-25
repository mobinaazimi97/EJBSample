package com.mftplus.jee11.model.service;

import com.mftplus.jee11.model.entity.User;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.*;
import jakarta.enterprise.event.Event;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.concurrent.TimeUnit;

@Stateless
@Named
public class UserService {
    @Schedule(dayOfMonth = "17", hour = "14")
    public void sayHello() {
        System.out.println("Hello World");
    }

    @RolesAllowed(value = {"admin", "manager"})
    public String test1() {
        Event<String> event;
        System.out.println("Hello World-Test1");
        return "Hello";
    }

    @AccessTimeout(value = 10, unit = TimeUnit.SECONDS)
    public void test2() {
        System.out.println("Hello World-Test2");
    }

    @PersistenceContext(unitName = "mft11")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void save(User user) {
        entityManager.persist(user);

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void update(User user) {
        entityManager.merge(user);

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void remove(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}
