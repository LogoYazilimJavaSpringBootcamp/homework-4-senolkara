package com.karakurt.hibernateandjpa.DataAccess;

import com.karakurt.hibernateandjpa.Entities.Provinces;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProvincesDao implements IProvincesDao {

    private EntityManager entityManager;

    @Autowired
    public ProvincesDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Provinces> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Provinces> provincesList = session.createQuery("from Provinces").getResultList();
        return provincesList;
    }

    @Override
    @Transactional
    public void add(Provinces province) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(province);
    }

    @Override
    @Transactional
    public void update(Provinces province) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(province);
    }

    @Override
    @Transactional
    public void delete(Provinces province) {
        Session session = entityManager.unwrap(Session.class);
        Provinces provinceToDelete = session.get(Provinces.class,province.getId());
        session.delete(provinceToDelete);
    }

    @Override
    @Transactional
    public Provinces getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Provinces.class,id);
    }
}
