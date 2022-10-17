package com.costume.repository;

import com.costume.model.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.costume.repository.crud.CostumeCrudRepository;

@Repository
public class CostumeRepository {
    @Autowired
    private CostumeCrudRepository costumeCrudRepository;
    
    public List<Cabin> getAll(){
        return (List<Cabin>) costumeCrudRepository.findAll();
    }
    
    public Optional<Cabin> getCostume(int id){
        return costumeCrudRepository.findById(id);
    }
    
    public Cabin save(Cabin costume){
        return costumeCrudRepository.save(costume);
    }
    
     public void delete(Cabin costume) {
        costumeCrudRepository.delete(costume);
    } 
}
