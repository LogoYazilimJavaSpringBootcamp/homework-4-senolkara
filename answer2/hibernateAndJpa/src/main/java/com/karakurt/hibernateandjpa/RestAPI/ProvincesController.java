package com.karakurt.hibernateandjpa.RestAPI;

import com.karakurt.hibernateandjpa.Business.IProvincesService;
import com.karakurt.hibernateandjpa.Entities.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProvincesController {
    private IProvincesService iProvincesService;

    @Autowired
    public ProvincesController(IProvincesService iProvincesService) {
        this.iProvincesService = iProvincesService;
    }

    @GetMapping("/provinces")
    public List<Provinces> get(){
        return iProvincesService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Provinces province){
        this.iProvincesService.add(province);
    }

    @PostMapping("/update")
    public void update(@RequestBody Provinces province){
        this.iProvincesService.update(province);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Provinces province){
        this.iProvincesService.delete(province);
    }

    @GetMapping("provinces/{id}")
    public Provinces getById(@PathVariable int id){
        return this.iProvincesService.getById(id);
    }
}
