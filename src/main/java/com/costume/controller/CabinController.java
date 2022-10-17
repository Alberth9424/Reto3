package com.costume.controller;

import com.costume.model.Cabin;
import com.costume.service.CabinService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin("*")
public class CabinController {
    @Autowired
    private CabinService cabinService;
    
    @GetMapping("/all")
    public List<Cabin> getAll(){
        return cabinService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cabin> getCostume(@PathVariable int id){
        return cabinService.getCostume(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin costume){
        return cabinService.save(costume);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCostume(@PathVariable int id){
        return cabinService.deleteCostume(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin updateCostume(@RequestBody Cabin costume){
        return cabinService.update(costume);
    }
}
