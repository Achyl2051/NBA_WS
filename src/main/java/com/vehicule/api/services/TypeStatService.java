package com.vehicule.api.services;

import com.vehicule.api.entity.TypeStat;
import com.vehicule.api.repository.TypeStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeStatService {
    private final TypeStatRepository typeStatRepository;

    @Autowired
    public TypeStatService(TypeStatRepository typeStatRepository) {
        this.typeStatRepository = typeStatRepository;
    }

    public TypeStat saveTypeStat(String nom, String code){
        TypeStat ts = new TypeStat();
        ts.setNom(nom);
        ts.setCode(code);
        ts = typeStatRepository.save(ts);
        return ts;
    }

    public void deleteTypeStat(Long id){
        typeStatRepository.deleteById(id);
    }

    public TypeStat updateTypeStat(Long id, TypeStat v){
        v.setId(id);
        typeStatRepository.save(v);
        return v;
    }
}
