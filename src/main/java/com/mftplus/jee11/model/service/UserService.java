package com.mftplus.jee11.model.service;

import com.mftplus.jee11.model.entity.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RequestScoped
public class UserService {
    @PersistenceContext(unitName = "mft11")

    private EntityManager entityManager;

    @Transactional
    public void save(User user) {
        entityManager.persist(user);

    }

    @Transactional
    public void update(User user) {
        entityManager.merge(user);

    }

    @Transactional
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}
