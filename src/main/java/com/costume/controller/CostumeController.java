package com.costume.controller;

import com.costume.model.Costume;
import com.costume.service.CostumeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/Costume")
@CrossOrigin("*")
public class CostumeController {
    @Autowired
    private CostumeService costumeService;
    
    @GetMapping("/all")
    public List<Costume> getAll(){
        return costumeService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Costume> getCostume(@PathVariable int id){
        return costumeService.getCostume(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume costume){
        return costumeService.save(costume);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCostume(@PathVariable int id){
        return costumeService.deleteCostume(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume updateCostume(@RequestBody Costume costume){
        return costumeService.update(costume);
    }
}
