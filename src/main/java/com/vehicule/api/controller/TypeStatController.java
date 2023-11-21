package com.vehicule.api.controller;

import com.vehicule.api.entity.TypeStat;
import com.vehicule.api.repository.TypeStatRepository;
import com.vehicule.api.services.TypeStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TypeStatController {
    private final TypeStatService typeStatService;
    private final TypeStatRepository typeStatRepository;
    @Autowired
    public TypeStatController(TypeStatService typeStatService, TypeStatRepository typeStatRepository){
        this.typeStatService = typeStatService;
        this.typeStatRepository = typeStatRepository;
    }

    @GetMapping("/typestats")
    public List<TypeStat> findAll(){
        return typeStatRepository.findAll();
    }

    @PostMapping("/typestat")
    public TypeStat save(String nom,String code){
        return typeStatService.saveTypeStat(nom, code);
    }

    @GetMapping("/typestats/{id}")
    public Optional<TypeStat> find(@PathVariable("id") Long id){
        return typeStatRepository.findById(id);
    }

    @PutMapping("/typestats/{id}")
    public TypeStat modif(@PathVariable Long id, @RequestBody TypeStat v){
        return typeStatService.updateTypeStat(id, v);
    }

    @DeleteMapping("/typestats/{id}")
    public void deleteById(@PathVariable Long id){
        typeStatService.deleteTypeStat(id);
    }

    @DeleteMapping("/typestats")
    public void deleteAll(){
        typeStatRepository.deleteAll();
    }
}
