package com.karakurt.hibernateandjpa.Business;

import com.karakurt.hibernateandjpa.Entities.Provinces;

import java.util.List;

public interface IProvincesService {
    List<Provinces> getAll();
    void add(Provinces province);
    void update(Provinces province);
    void delete(Provinces province);
    Provinces getById(int id);
}
