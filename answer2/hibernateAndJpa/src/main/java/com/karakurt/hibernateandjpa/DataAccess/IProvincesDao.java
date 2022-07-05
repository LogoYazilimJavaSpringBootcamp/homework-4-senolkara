package com.karakurt.hibernateandjpa.DataAccess;

import com.karakurt.hibernateandjpa.Entities.Provinces;

import java.util.List;

public interface IProvincesDao {
    List<Provinces> getAll();
    void add(Provinces province);
    void update(Provinces province);
    void delete(Provinces province);
    Provinces getById(int id);
}
