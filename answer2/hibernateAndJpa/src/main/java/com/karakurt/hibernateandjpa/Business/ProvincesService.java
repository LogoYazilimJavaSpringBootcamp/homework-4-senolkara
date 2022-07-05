package com.karakurt.hibernateandjpa.Business;

import com.karakurt.hibernateandjpa.DataAccess.IProvincesDao;
import com.karakurt.hibernateandjpa.Entities.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProvincesService implements IProvincesService {

    private IProvincesDao iProvincesDao;

    @Autowired
    public ProvincesService(IProvincesDao iProvincesDao) {
        this.iProvincesDao = iProvincesDao;
    }

    @Override
    @Transactional
    public List<Provinces> getAll() {
        return this.iProvincesDao.getAll();
    }

    @Override
    @Transactional
    public void add(Provinces province) {
        this.iProvincesDao.add(province);
    }

    @Override
    @Transactional
    public void update(Provinces province) {
        this.iProvincesDao.update(province);
    }

    @Override
    @Transactional
    public void delete(Provinces province) {
        this.iProvincesDao.delete(province);
    }

    @Override
    @Transactional
    public Provinces getById(int id) {
        return this.iProvincesDao.getById(id);
    }
}
